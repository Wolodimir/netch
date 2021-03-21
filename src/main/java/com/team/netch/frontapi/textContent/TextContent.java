package com.team.netch.frontapi.textContent;

import javax.persistence.Id;

public class TextContent {
    @Id
    private Long id;

    private String name;
    private String header;
    private String body;

}
