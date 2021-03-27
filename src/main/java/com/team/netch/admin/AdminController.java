package com.team.netch.admin;

import com.team.netch.frontapi.textContent.TextContent;
import com.team.netch.frontapi.textContent.TextContentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "admin/api")
@CrossOrigin
public class AdminController {
    private final TextContentService textContentService;

    public AdminController(TextContentService textContentService) {
        this.textContentService = textContentService;
    }

    @GetMapping
    public String adminPage(){
        return "Something administrative";
    }

    /*_____________________________
    * TEXT CONTENT SECTION
    * _____________________________*/

    @PostMapping(path = "textContent/add")
    public String addTextContent(@RequestBody TextContent textContent){
        textContentService.save(textContent);
        return "saved";
    }

    /*_____________________________
     * END TEXT CONTENT SECTION
     * _____________________________*/
}
