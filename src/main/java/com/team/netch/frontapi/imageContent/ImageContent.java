package com.team.netch.frontapi.imageContent;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ImageContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(columnDefinition = "text")
    private String header;
    @Column(columnDefinition = "text")
    private String body;
    private String imageUrl;

    public ImageContent(String name, String header, String body, String imageUrl) {
        this.name = name;
        this.header = header;
        this.body = body;
        this.imageUrl = imageUrl;
    }

    public ImageContent(Long id, String name, String header, String body, String imageUrl) {
        this.id = id;
        this.name = name;
        this.header = header;
        this.body = body;
        this.imageUrl = imageUrl;
    }

    public ImageContent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
