package com.example.android.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

public class FootballNewsFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<News>> {

    private static final int NEWS_LOADER_ID = 1;

    private NewsAdapter mAdapter;

    private static final String GUARDIAN_REQUEST_URL =
            "https://content.guardianapis.com/search?section=football&api-key=9f43069a-520c-4549-937b-c78825908d24";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.news_list_item, container, false);

        LoaderManager loaderManager = LoaderManager.getInstance(this);
        loaderManager.initLoader(NEWS_LOADER_ID, null, this);


        mAdapter = new NewsAdapter(getActivity(), new ArrayList<News>());

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(mAdapter);

        // Inflate the layout for this fragment
        return rootView;
    }

    @NonNull
    @Override
    public Loader<List<News>> onCreateLoader(int id, @Nullable Bundle args) {
        // Create a new loader for the given URL
        return new NewsLoader(getContext(), GUARDIAN_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<News>> loader, List<News> news) {
        // Clear the adapter of previous earthquake data
        mAdapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (news != null && !news.isEmpty()) {
            mAdapter.addAll(news);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<News>> loader) {
        // Loader reset, so we can clear out our existing data.
        mAdapter.clear();
    }
}
