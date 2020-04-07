package com.example.android.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;

public class FeaturedNewsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.news_list_item, container, false);

        final List<News> news = new ArrayList<News>();
        news.add(new News("Australia news",
                "Coronavirus live news: Trump says he won't wear face mask despite new US advice",
                "2020-04-03T23:33:57Z",
                "https://www.theguardian.com/world/live/2020/apr/03/coronavirus-update-live-news-usa-uk-spain-italy-china-who-middle-east-spike-world-global-cases-latest-updates"));

        news.add(new News("World news",
                "Coronavirus live news: Trump says he won't wear face mask despite new US advice",
                "2020-04-03T23:33:57Z",
                "https://www.theguardian.com/world/live/2020/apr/03/coronavirus-update-live-news-usa-uk-spain-italy-china-who-middle-east-spike-world-global-cases-latest-updates"));


        NewsAdapter adapter = new NewsAdapter(getActivity(), news);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return rootView;
    }

}
