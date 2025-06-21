package com.example.mobileapi.dto.request;

import java.util.List;

public class PostRequestDTO {
    private String title;
    private String content;
    private String status;
    private String thumbnail;
    private String category;
    private String author;
    private int views;
    private List<String> tags;

    // Getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getThumbnail() { return thumbnail; }
    public void setThumbnail(String thumbnail) { this.thumbnail = thumbnail; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public int getViews() { return views; }
    public void setViews(int views) { this.views = views; }
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }
} 