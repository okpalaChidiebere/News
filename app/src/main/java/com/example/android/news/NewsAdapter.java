package com.example.android.news;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NewsAdapter extends ArrayAdapter<News> {

    private static final String LOCATION_SEPARATOR = " ";

    private static final int SECOND_MILLIS = 1000;
    private static final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
    private static final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
    private static final int DAY_MILLIS = 24 * HOUR_MILLIS;

    public NewsAdapter(Context context, List<News> News){
        super(context, 0, News);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemViewRow = convertView;
        if (listItemViewRow == null) {
            listItemViewRow = LayoutInflater.from(getContext()).inflate(
                    R.layout.fragment_news_list_item, parent, false);
        }

        News news = getItem(position);

        TextView newTitle = (TextView) listItemViewRow.findViewById(R.id.news_title);
        newTitle.setText(news.getWebTitle());

        TextView newsSection = (TextView) listItemViewRow.findViewById(R.id.news_section);
        String originalSectionName = news.getSectionId();
        String primarySection;
        String[] parts = originalSectionName.split(LOCATION_SEPARATOR);
        primarySection = parts[0];
        newsSection.setText(primarySection);

        TextView newsPublishTime = (TextView) listItemViewRow.findViewById(R.id.news_posted_time);
        String convertTime = covertTimeToText(news.getWebPublicationDate());
        newsPublishTime.setText(convertTime);



        return listItemViewRow;
    }

    private String covertTimeToText(String dataDate) {

        String convTime = null;

        String prefix = "";
        String suffix = "Ago";

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
            Date pasTime = dateFormat.parse(dataDate);
            Date nowTime = new Date();

            long dateDiff = nowTime.getTime() - pasTime.getTime();
            //Log.i("pastTime: ",""+dateDiff);

            int second = (int) (dateDiff / 1000) % 60 ;
            int minute = (int) ((dateDiff / (1000*60)) % 60);
            int hour   = (int) ((dateDiff / (1000*60*60)) % 24);
            int day = (int) (dateDiff / (1000*60*60*24));

            //System.out.println("Day " + day + " Hour " + hour + " Minute " + minute + " Seconds " + second);
            if (day >= 7) {
                if (day > 360) {
                    return (day / 30) + " Years " + suffix;
                } else if (day > 30) {
                    return (day / 360) + " Months " + suffix;
                } else {
                    return (day / 7) + " Week " + suffix;
                }
            }

            if (dateDiff < MINUTE_MILLIS) {
                return "just now";
            } else if (dateDiff < 2 * MINUTE_MILLIS) {
                return "a minute ago";
            } else if (dateDiff < 50 * MINUTE_MILLIS) {
                return dateDiff / MINUTE_MILLIS + " minutes ago";
            } else if (dateDiff < 90 * MINUTE_MILLIS) {
                return "an hour ago";
            } else if (dateDiff < 24 * HOUR_MILLIS) {
                return dateDiff / HOUR_MILLIS + " hours ago";
            } else if (dateDiff < 48 * HOUR_MILLIS) {
                return "yesterday";
            } else {
                return dateDiff / DAY_MILLIS + " days ago";
            }

        } catch (ParseException e) {
            e.printStackTrace();
            Log.e("ConvTimeE", e.getMessage());
        }

        return convTime;
    }
}
