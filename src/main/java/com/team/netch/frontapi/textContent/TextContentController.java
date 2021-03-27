package com.team.netch.frontapi.textContent;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/front")
@CrossOrigin
public class TextContentController {
    /*
    * This controller is public and have just GET methods.
    * POST logic is in the ADMIN controller
    * */

    private final TextContentService textContentService;

    public TextContentController(TextContentService textContentService) {
        this.textContentService = textContentService;
    }

    @GetMapping("allText")
    public List<TextContent> allTextContent(){
        return textContentService.getAllTextContent();
    }
}
