package com.team.netch.admin;

import com.team.netch.feedback.Feedback;
import com.team.netch.feedback.FeedbackService;
import com.team.netch.frontapi.imageContent.ImageContentService;
import com.team.netch.frontapi.textContent.TextContent;
import com.team.netch.frontapi.textContent.TextContentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(path = "admin/api")
@CrossOrigin
public class AdminController {

    private final TextContentService textContentService;
    private final ImageContentService imageContentService;
    private final FeedbackService feedbackService;

    public AdminController(TextContentService textContentService,
                           ImageContentService imageContentService,
                           FeedbackService feedbackService) {
        this.textContentService = textContentService;
        this.imageContentService = imageContentService;
        this.feedbackService = feedbackService;
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

    @DeleteMapping(path = "textContent/{id}")
    public String deleteTextContent(@PathVariable Long id){
        textContentService.deleteTextContentById(id);
        return "deleted " + id;
    }

    /*_____________________________
     * END TEXT CONTENT SECTION
     * _____________________________*/


    /*_____________________________
     * IMAGE CONTENT SECTION
     * _____________________________*/

    @PostMapping(path = "imageContent/add")
    public String addImageContent(@RequestParam MultipartFile multipartFile,
                                  @RequestParam String name,
                                  @RequestParam String header,
                                  @RequestParam String body){

        imageContentService.saveImageContent(multipartFile, name, header, body);
        return "saved";
    }

    @DeleteMapping(path = "imageContent/{id}")
    public String deleteImageContent(@PathVariable Long id){
        imageContentService.deleteImageContentById(id);
        return "deleted " + id;
    }


    /*_____________________________
     * END IMAGE CONTENT SECTION
     * _____________________________*/

    /*_____________________________
     * FEEDBACK SECTION
     * _____________________________*/

    @GetMapping(path = "feedback")
    public List<Feedback> getActiveFeedback(){
        return feedbackService.getAllActiveFeedback();
    }

    @DeleteMapping(path = "feedback/{id}")
    public String deleteFeedback(@PathVariable Long id){
        feedbackService.offFeedbackById(id);
        return "deleted " + id;
    }


    /*_____________________________
     * END FEEDBACK SECTION
     * _____________________________*/



}
