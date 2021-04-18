package com.team.netch.admin;

import com.team.netch.brief.Brief;
import com.team.netch.brief.BriefService;
import com.team.netch.feedback.Feedback;
import com.team.netch.feedback.FeedbackService;
import com.team.netch.frontapi.imageContent.ImageContentService;
import com.team.netch.frontapi.textContent.TextContent;
import com.team.netch.frontapi.textContent.TextContentService;
import com.team.netch.progress.Progress;
import com.team.netch.progress.ProgressService;
import com.team.netch.regLogAdminSecurity.appUser.AppUser;
import com.team.netch.regLogAdminSecurity.appUser.AppUserService;
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
    private final AppUserService appUserService;
    private final BriefService briefService;
    private final ProgressService progressService;

    public AdminController(TextContentService textContentService,
                           ImageContentService imageContentService,
                           FeedbackService feedbackService,
                           AppUserService appUserService,
                           BriefService briefService, ProgressService progressService) {
        this.textContentService = textContentService;
        this.imageContentService = imageContentService;
        this.feedbackService = feedbackService;
        this.appUserService = appUserService;
        this.briefService = briefService;
        this.progressService = progressService;
    }

    /*_____________________________
    * TEXT CONTENT SECTION
    * _____________________________*/

    /*@PostMapping(path = "textContent/add")
    public void addTextContent(@RequestBody TextContent textContent){
        textContentService.save(textContent);
    }

    @DeleteMapping(path = "textContent/{id}")
    public Long deleteTextContent(@PathVariable Long id){
        textContentService.deleteTextContentById(id);
        return id;
    }*/

    /*_____________________________
     * END TEXT CONTENT SECTION
     * _____________________________*/


    /*_____________________________
     * IMAGE CONTENT SECTION
     * _____________________________*/

    /*@PostMapping(path = "imageContent/add")
    public void addImageContent(@RequestParam MultipartFile multipartFile,
                                  @RequestParam String name,
                                  @RequestParam String header,
                                  @RequestParam String body){

        imageContentService.saveImageContent(multipartFile, name, header, body);
    }

    @DeleteMapping(path = "imageContent/{id}")
    public Long deleteImageContent(@PathVariable Long id){
        imageContentService.deleteImageContentById(id);
        return id;
    }*/


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

    @GetMapping(path = "feedback/all")
    public List<Feedback> getAllFeedback(){
        return feedbackService.getAllFeedback();
    }

    @DeleteMapping(path = "feedback/{id}")
    public Long deleteFeedback(@PathVariable Long id){
        feedbackService.offFeedbackById(id);
        return id;
    }


    /*_____________________________
     * END FEEDBACK SECTION
     * _____________________________*/

    /*_____________________________
     * USERS SECTION
     * _____________________________*/

    @GetMapping(path = "users")
    public List<AppUser> showUsers(){
        return appUserService.showAllUsers();
    }

    /*_____________________________
     * END USERS SECTION
     * _____________________________*/

    /*_____________________________
     * BRIEF SECTION
     * _____________________________*/

    @GetMapping(path = "briefs")
    public List<Brief> showBriefs(){
        return briefService.getAll();
    }

    @GetMapping(path = "briefs/{id}")
    public Brief getOne(@PathVariable Long id){
        return briefService.getById(id);
    }

    @GetMapping(path = "briefs/active")
    public List<Brief> showActiveBriefs(){
        return briefService.getActive();
    }

    @GetMapping(path = "briefs/notActive")
    public List<Brief> showNotActiveBriefs(){
        return briefService.getNotActive();
    }

    @DeleteMapping(path = "briefs/{id}")
    public Long deactivate(@PathVariable Long id){
        briefService.deactivate(id);
        return id;
    }

    /*_____________________________
     * END BRIEF SECTION
     * _____________________________*/

    /*_____________________________
     * PROGRESS SECTION
     * _____________________________*/

    @GetMapping("progress")
    public List<Progress> getAllProgress(){
        return progressService.getAll();
    }

    @PostMapping("progress/change")
    public void changeProgress(@RequestParam String parameter, @RequestParam String id){
        progressService.changeProgress(parameter, Long.parseLong(id));
    }

    @GetMapping("progress/active")
    public List<Progress> getActiveProgress(){
        return progressService.getActive();
    }

    /*_____________________________
     * END PROGRESS SECTION
     * _____________________________*/
}
