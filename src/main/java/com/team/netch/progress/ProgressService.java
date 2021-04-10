package com.team.netch.progress;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressService {

    private final ProgressRepo progressRepo;

    public ProgressService(ProgressRepo progressRepo) {
        this.progressRepo = progressRepo;
    }

    public Progress getProgressById(Long id){
        return progressRepo.findById(id).orElseThrow(() -> new IllegalStateException("progress not found"));
    }

    public void changeProgress(String parameter, Long id){
        Progress progress = progressRepo.findById(id).get();
        switch (parameter){
            case "technicalTask" : progress.setTechnicalTask(true);
                break;
            case "prototype" : progress.setPrototype(true);
                break;
            case "siteModel" : progress.setSiteModel(true);
                break;
            case "frontBack" : progress.setFrontBack(true);
                break;
            case "testing" : progress.setTesting(true);
                break;
            case "payment" : progress.setPayment(true);
                break;
            case "result" : progress.setResult(true);
                break;
        }
        progressRepo.save(progress);
    }

    public String save(Progress progress){

        progressRepo.save(progress);

        return "saved";
    }

    public List<Progress> getAll() {
        return progressRepo.findAll();
    }

    public List<Progress> getActive() {
        return progressRepo.findProgressByUserBriefStatusEquals(true);
    }
}
