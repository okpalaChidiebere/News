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

        List<News> news = QueryUtils.extractFeatureFromJson();


        NewsAdapter adapter = new NewsAdapter(getActivity(), news);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return rootView;
    }

}
