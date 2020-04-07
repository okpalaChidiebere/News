package com.example.android.news;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    View myFragment;
    TabLayout tabLayout;
    ViewPager viewPager;


    public NewsFragment() {
        // Required empty public constructor
    }

    public static NewsFragment getInstance(){
        return new NewsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myFragment =  inflater.inflate(R.layout.fragment_news, container, false);

        // Find the view pager that will allow the user to swipe between fragments
        viewPager = (ViewPager) myFragment.findViewById(R.id.news_viewPager);

        // Find the tab layout that shows the tabs
        tabLayout = (TabLayout) myFragment.findViewById(R.id.news_tabLayout);


        return myFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setUpViewPager(ViewPager viewPager){
        SectionFragmentAdapter adapter = new SectionFragmentAdapter(getChildFragmentManager());

        adapter.addFragment(new FeaturedNewsFragment(), getString(R.string.features_category));
        adapter.addFragment(new FootballNewsFragment(), getString(R.string.football_category));
        adapter.addFragment(new WorldNewsFragment(), getString(R.string.world_category));

        viewPager.setAdapter(adapter);
    }
}
