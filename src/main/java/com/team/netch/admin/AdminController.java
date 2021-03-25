package com.team.netch.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "admin/api")
@CrossOrigin
public class AdminController {

    @GetMapping
    public String adminPage(){
        return "Something administrative";
    }
}
