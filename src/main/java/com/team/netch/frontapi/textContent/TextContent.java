package com.team.netch.frontapi.textContent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TextContent {
    @Id
    private Long id;

    private String name;
    @Column(columnDefinition = "text")
    private String header;
    @Column(columnDefinition = "text")
    private String body;

    public TextContent(String name, String header, String body) {
        this.name = name;
        this.header = header;
        this.body = body;
    }

    public TextContent(Long id, String name, String header, String body) {
        this.id = id;
        this.name = name;
        this.header = header;
        this.body = body;
    }

    public TextContent() {
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
}
