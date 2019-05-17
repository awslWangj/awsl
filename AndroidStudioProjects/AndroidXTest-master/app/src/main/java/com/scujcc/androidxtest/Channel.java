package com.scujcc.androidxtest;

import java.io.Serializable;

public class Channel implements Serializable {
    private String biaoti;
    private String zhiliang;
    private String url;

    public String getTitle() {
        return biaoti;
    }

    public void setTitle(String title) {
        this.biaoti = title;
    }

    public String getQuality() {
        return zhiliang;
    }

    public void setQuality(String quality) {
        this.zhiliang = quality;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
