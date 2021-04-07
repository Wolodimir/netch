package com.team.netch.brief;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BriefService {

    private final BriefRepo briefRepo;

    public BriefService(BriefRepo briefRepo) {
        this.briefRepo = briefRepo;
    }

    public void save(Brief brief) {
        briefRepo.save(brief);
    }

    public List<Brief> getAll() {
        return briefRepo.findAll();
    }

    public List<Brief> getActive(){
        return briefRepo.findByStatusEquals(true);
    }

    public List<Brief> getNotActive(){
        return briefRepo.findByStatusEquals(false);
    }
}
