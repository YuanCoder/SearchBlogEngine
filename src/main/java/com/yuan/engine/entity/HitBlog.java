package com.yuan.engine.entity;

import java.io.Serializable;

/**
 * 所搜命中的博文信息
 * Created by Yuanjp on 2017/6/14 0014.
 */
public class HitBlog implements Serializable{

    private String title; //博文标题
    private String content;//简介
    private String unescapedUrl;//地址

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUnescapedUrl() {
        return unescapedUrl;
    }

    public void setUnescapedUrl(String unescapedUrl) {
        this.unescapedUrl = unescapedUrl;
    }
}