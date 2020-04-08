package com.example.android.news;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

final class QueryUtils {

    private static final String SAMPLE_JSON_RESPONSE = "{\"response\":{\"status\":\"ok\",\"userTier\":\"developer\",\"total\":2184064,\"startIndex\":1,\"pageSize\":10,\"currentPage\":1,\"pages\":218407,\"orderBy\":\"newest\",\"results\":[{\"id\":\"world/live/2020/apr/07/coronavirus-live-news-boris-johnson-intensive-care-uk-donald-trump-america-us-praying-recovery-latest-updates\",\"type\":\"liveblog\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2020-04-07T11:52:57Z\",\"webTitle\":\"Coronavirus live news: Boris Johnson in intensive care as Japan declares state of emergency\",\"webUrl\":\"https://www.theguardian.com/world/live/2020/apr/07/coronavirus-live-news-boris-johnson-intensive-care-uk-donald-trump-america-us-praying-recovery-latest-updates\",\"apiUrl\":\"https://content.guardianapis.com/world/live/2020/apr/07/coronavirus-live-news-boris-johnson-intensive-care-uk-donald-trump-america-us-praying-recovery-latest-updates\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"world/live/2020/apr/07/uk-coronavirus-live-news-boris-johnson-spends-night-in-intensive-care\",\"type\":\"liveblog\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2020-04-07T11:52:54Z\",\"webTitle\":\"UK coronavirus live news:  Boris Johnson remains in intensive care as Michael Gove self-isolates\",\"webUrl\":\"https://www.theguardian.com/world/live/2020/apr/07/uk-coronavirus-live-news-boris-johnson-spends-night-in-intensive-care\",\"apiUrl\":\"https://content.guardianapis.com/world/live/2020/apr/07/uk-coronavirus-live-news-boris-johnson-spends-night-in-intensive-care\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"australia-news/2020/apr/07/pope-francis-decries-unjust-sentences-after-cardinal-george-pell-acquitted\",\"type\":\"article\",\"sectionId\":\"australia-news\",\"sectionName\":\"Australia news\",\"webPublicationDate\":\"2020-04-07T11:45:40Z\",\"webTitle\":\"Pope Francis decries 'unjust sentences' after cardinal George Pell acquitted\",\"webUrl\":\"https://www.theguardian.com/australia-news/2020/apr/07/pope-francis-decries-unjust-sentences-after-cardinal-george-pell-acquitted\",\"apiUrl\":\"https://content.guardianapis.com/australia-news/2020/apr/07/pope-francis-decries-unjust-sentences-after-cardinal-george-pell-acquitted\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"business/2020/apr/07/cineworld-talks-with-landlords-and-studios-to-weather-coronavirus\",\"type\":\"article\",\"sectionId\":\"business\",\"sectionName\":\"Business\",\"webPublicationDate\":\"2020-04-07T11:40:21Z\",\"webTitle\":\"Cineworld talks with landlords and studios to weather coronavirus\",\"webUrl\":\"https://www.theguardian.com/business/2020/apr/07/cineworld-talks-with-landlords-and-studios-to-weather-coronavirus\",\"apiUrl\":\"https://content.guardianapis.com/business/2020/apr/07/cineworld-talks-with-landlords-and-studios-to-weather-coronavirus\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"business/live/2020/apr/07/stock-markets-gain-coronavirus-spread-ftse-100-currencies-us-dollar-sterling-british-pound-boris-johnson-business-live\",\"type\":\"liveblog\",\"sectionId\":\"business\",\"sectionName\":\"Business\",\"webPublicationDate\":\"2020-04-07T11:37:36Z\",\"webTitle\":\"Stock markets gain on signs of slowing coronavirus spread – business live\",\"webUrl\":\"https://www.theguardian.com/business/live/2020/apr/07/stock-markets-gain-coronavirus-spread-ftse-100-currencies-us-dollar-sterling-british-pound-boris-johnson-business-live\",\"apiUrl\":\"https://content.guardianapis.com/business/live/2020/apr/07/stock-markets-gain-coronavirus-spread-ftse-100-currencies-us-dollar-sterling-british-pound-boris-johnson-business-live\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"sport/2020/apr/07/walter-gilbert-shamed-thief-who-shone-canadian-exile-the-spin-cricket\",\"type\":\"article\",\"sectionId\":\"sport\",\"sectionName\":\"Sport\",\"webPublicationDate\":\"2020-04-07T11:28:42Z\",\"webTitle\":\"The Spin | Walter Gilbert, the shamed thief who shone in Canadian exile\",\"webUrl\":\"https://www.theguardian.com/sport/2020/apr/07/walter-gilbert-shamed-thief-who-shone-canadian-exile-the-spin-cricket\",\"apiUrl\":\"https://content.guardianapis.com/sport/2020/apr/07/walter-gilbert-shamed-thief-who-shone-canadian-exile-the-spin-cricket\",\"isHosted\":false,\"pillarId\":\"pillar/sport\",\"pillarName\":\"Sport\"},{\"id\":\"world/2020/apr/07/japan-shinzo-abe-declares-state-of-emergency-over-coronavirus\",\"type\":\"article\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2020-04-07T11:21:06Z\",\"webTitle\":\"Japan declares state of emergency over coronavirus\",\"webUrl\":\"https://www.theguardian.com/world/2020/apr/07/japan-shinzo-abe-declares-state-of-emergency-over-coronavirus\",\"apiUrl\":\"https://content.guardianapis.com/world/2020/apr/07/japan-shinzo-abe-declares-state-of-emergency-over-coronavirus\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"world/2020/apr/07/coronavirus-latest-news-at-a-glance\",\"type\":\"article\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2020-04-07T11:20:40Z\",\"webTitle\":\"Coronavirus latest: at a glance\",\"webUrl\":\"https://www.theguardian.com/world/2020/apr/07/coronavirus-latest-news-at-a-glance\",\"apiUrl\":\"https://content.guardianapis.com/world/2020/apr/07/coronavirus-latest-news-at-a-glance\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"sport/2020/apr/07/kelly-loeffler-the-wnba-owner-against-everything-the-league-stands-for\",\"type\":\"article\",\"sectionId\":\"sport\",\"sectionName\":\"Sport\",\"webPublicationDate\":\"2020-04-07T11:00:20Z\",\"webTitle\":\"Kelly Loeffler: the WNBA owner against everything the league stands for\",\"webUrl\":\"https://www.theguardian.com/sport/2020/apr/07/kelly-loeffler-the-wnba-owner-against-everything-the-league-stands-for\",\"apiUrl\":\"https://content.guardianapis.com/sport/2020/apr/07/kelly-loeffler-the-wnba-owner-against-everything-the-league-stands-for\",\"isHosted\":false,\"pillarId\":\"pillar/sport\",\"pillarName\":\"Sport\"},{\"id\":\"sport/2020/apr/07/my-favourite-game-nick-faldo-greg-norman-1996-masters\",\"type\":\"article\",\"sectionId\":\"sport\",\"sectionName\":\"Sport\",\"webPublicationDate\":\"2020-04-07T11:00:19Z\",\"webTitle\":\"My favourite game: Nick Faldo v Greg Norman, 1996 Masters | Ewan Murray\",\"webUrl\":\"https://www.theguardian.com/sport/2020/apr/07/my-favourite-game-nick-faldo-greg-norman-1996-masters\",\"apiUrl\":\"https://content.guardianapis.com/sport/2020/apr/07/my-favourite-game-nick-faldo-greg-norman-1996-masters\",\"isHosted\":false,\"pillarId\":\"pillar/sport\",\"pillarName\":\"Sport\"}]}}";
    private QueryUtils() {
    }

    public static List<News> extractFeatureFromJson() {

        ArrayList<News> news = new ArrayList<>();
        try {
            JSONObject jsonObjRoot = new JSONObject(SAMPLE_JSON_RESPONSE);

            JSONObject response = jsonObjRoot.getJSONObject("response");

            JSONArray results = response.getJSONArray("results");

            for (int i = 0; i < results.length(); i++) {

                JSONObject currentArrayPosition = results.getJSONObject(i);

                String webTitle = currentArrayPosition.getString("webTitle");
                String sectionName = currentArrayPosition.getString("sectionName");
                String publishTime = currentArrayPosition.getString("webPublicationDate");
                String newsUrl = currentArrayPosition.getString("webUrl");

                News newsObjectClassInstance = new News(sectionName, webTitle, publishTime, newsUrl);
                news.add(newsObjectClassInstance);
            }

        }catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }

        // Return the list of news
        return news;
    }
}
