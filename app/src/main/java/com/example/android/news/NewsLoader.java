package com.example.android.news;

import android.content.Context;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    /** Query URL */
    private String mUrl;

    public NewsLoader(Context context, String url){
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
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
