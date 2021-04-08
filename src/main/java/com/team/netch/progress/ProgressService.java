package com.team.netch.progress;

import org.springframework.stereotype.Service;

@Service
public class ProgressService {

    private final ProgressRepo progressRepo;

    public ProgressService(ProgressRepo progressRepo) {
        this.progressRepo = progressRepo;
    }

    public Progress getProgressById(Long id){
        return progressRepo.findById(id).orElse(new Progress());
    }

    public String save(Progress progress){

        progressRepo.save(progress);

        return "saved";
    }
}
