package com.team.netch.brief;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BriefService {

    private final BriefRepo briefRepo;

    public BriefService(BriefRepo briefRepo) {
        this.briefRepo = briefRepo;
    }

    public void save(Brief brief) {
        brief.setCreatedAt(LocalDateTime.now().withNano(0));
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

    public void deactivate(Long id) {
        Optional<Brief> briefById = briefRepo.findById(id);
        Brief brief = briefById.get();
        brief.setStatus(false);
        briefRepo.save(brief);
    }
}
