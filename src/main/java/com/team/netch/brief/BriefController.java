package com.team.netch.brief;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "api/brief")
public class BriefController {

    private final BriefService briefService;

    public BriefController(BriefService briefService) {
        this.briefService = briefService;
    }


    @PostMapping
    public String addBrief(@RequestBody Brief brief){

        briefService.save(brief);

        return "Спасибо, что заполнили бриф!";
    }
}
