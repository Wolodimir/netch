package com.team.netch.admin;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/admin")
@CrossOrigin
public class AdminController {

    @GetMapping
    public String adminPage(){
        return "Something administrative";
    }
}
