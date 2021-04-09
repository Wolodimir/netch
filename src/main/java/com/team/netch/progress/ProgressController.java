package com.team.netch.progress;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "api/progress")
public class ProgressController {

    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    @GetMapping("{id}")
    public Progress progress(@PathVariable Long id){
        return progressService.getProgressById(id);
    }

}
