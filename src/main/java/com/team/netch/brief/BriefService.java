package com.team.netch.brief;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class BriefService {

    private final BriefRepo briefRepo;

    public BriefService(BriefRepo briefRepo) {
        this.briefRepo = briefRepo;
    }

    public void save(Brief brief) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy", Locale.US);
        LocalDateTime strLocalDate = LocalDateTime.now();
        String localDate = strLocalDate.format(formatter);
        brief.setCreatedAt(localDate);

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
