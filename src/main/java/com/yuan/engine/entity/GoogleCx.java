package com.yuan.engine.entity;

/**
 * 自定义google 搜索 key
 * Created by Yuanjp on 2017/6/14 0014.
 */
public class GoogleCx {

    private Integer id;
    private String key; // 自定义google搜索key   当一个key 的使用次数超过一定数量时 Google服务器 会认为是爬虫 降低响应速度
    private String engineName; // 引擎名
    private String description; //描述

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "GoogleCx{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", engineName='" + engineName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
