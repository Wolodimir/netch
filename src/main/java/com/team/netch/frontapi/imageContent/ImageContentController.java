package com.team.netch.frontapi.imageContent;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/front")
public class ImageContentController {

    private final ImageContentService imageContentService;

    public ImageContentController(ImageContentService imageContentService) {
        this.imageContentService = imageContentService;
    }


    @GetMapping("allImageContent")
    public List<ImageContent> getAllImageContent(){
        return imageContentService.getAllImageContent();
    }

    @GetMapping("imageContent/{name}")
    public List<ImageContent> getImageContentByName(@PathVariable String name){
        return imageContentService.getImageContentByName(name);
    }





}
