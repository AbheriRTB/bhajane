package com.abheri.bhajane;

import android.graphics.Color;

public class BhajaneData {
    private String content;
    private String title;
    private int imgId;
    private int colorFilter;

    public BhajaneData(String title, String content, int imgId, Integer... colFilter) {
        this.content = content;
        this.title = title;
        this.imgId = imgId;
        colorFilter = colFilter.length > 0? (int)colFilter[0]: (int)Color.TRANSPARENT;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getImgId() {
        return imgId;
    }
    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
    public int getColorFilter() {
        return colorFilter;
    }
    public void setColorFilter(int colFilter) {
        this.colorFilter = colFilter;
    }
}