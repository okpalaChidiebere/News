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
import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NewsAdapter extends ArrayAdapter<News> {

    private static final String LOCATION_SEPARATOR = " ";

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

    public String covertTimeToText(String dataDate) {

        String convTime = null;

        String prefix = "";
        String suffix = "Ago";

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date pasTime = dateFormat.parse(dataDate);

            Date nowTime = new Date();

            long dateDiff = nowTime.getTime() - pasTime.getTime();

            long second = TimeUnit.MILLISECONDS.toSeconds(dateDiff);
            long minute = TimeUnit.MILLISECONDS.toMinutes(dateDiff);
            long hour   = TimeUnit.MILLISECONDS.toHours(dateDiff);
            long day  = TimeUnit.MILLISECONDS.toDays(dateDiff);

            if (second < 60) {
                convTime = second+" Seconds "+suffix;
            } else if (minute < 60) {
                convTime = minute+" Minutes "+suffix;
            } else if (hour < 24) {
                convTime = hour+" Hours "+suffix;
            } else if (day >= 7) {
                if (day > 360) {
                    convTime = (day / 30) + " Years " + suffix;
                } else if (day > 30) {
                    convTime = (day / 360) + " Months " + suffix;
                } else {
                    convTime = (day / 7) + " Week " + suffix;
                }
            } else if (day < 7) {
                convTime = day+" Days "+suffix;
            }

        } catch (ParseException e) {
            e.printStackTrace();
            Log.e("ConvTimeE", e.getMessage());
        }

        return convTime;
    }
}
