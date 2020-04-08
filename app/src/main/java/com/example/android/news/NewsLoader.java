package com.example.android.news;

import android.content.Context;
import android.util.Log;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    private static final String LOG_TAG = NewsLoader.class.getName();;
    /** Query URL */
    private String mUrl;

    public NewsLoader(Context context, String url){
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
        Log.i(LOG_TAG, "TEST: OnStartLoading. calling forceLoad to trigger the loadInBackground method");
    }

    @Nullable
    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<News> news = QueryUtils.fetchEarthquakeData(mUrl);
        return news;
    }
}
