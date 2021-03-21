package com.team.netch.frontapi.imageContent;

import javax.persistence.Id;

public class ImageContent {
    @Id
    private Long id;

    private String name;
    private String header;
    private String body;
    private String imageUrl;
}
