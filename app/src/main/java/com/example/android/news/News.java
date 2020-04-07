package com.example.android.news;

public class News {

    /** Section of the News */
    private String mSectionName;

    /** Title of the news*/
    private String mWebTitle;

    /** publication date of the news */
    private String mWebPublicationDate;

    /** url of the news web page */
    private String mUrl;

    public News(String sectionName, String webTitle, String date, String url){
        mSectionName = sectionName;
        mWebTitle = webTitle;
        mWebPublicationDate = date;
        mUrl = url;
    }

    String getSectionId(){
        return mSectionName;
    }

    String getWebTitle(){
        return mWebTitle;
    }

    String getWebPublicationDate(){
        return mWebPublicationDate;
    }

    String getUrl(){
        return mUrl;
    }

}
