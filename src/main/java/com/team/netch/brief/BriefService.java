package com.team.netch.brief;

import com.team.netch.progress.Progress;
import com.team.netch.progress.ProgressRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class BriefService {

    private final BriefRepo briefRepo;
    private final ProgressRepo progressRepo;

    public BriefService(BriefRepo briefRepo, ProgressRepo progressRepo) {
        this.briefRepo = briefRepo;
        this.progressRepo = progressRepo;
    }

    public String save(Brief brief) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy", Locale.US);
        LocalDateTime strLocalDate = LocalDateTime.now();
        String localDate = strLocalDate.format(formatter);
        brief.setCreatedAt(localDate);

        Progress progress = new Progress();
        progress.setUserBrief(brief);
        progress.setBrief(true);

        briefRepo.save(brief);

        progressRepo.save(progress);
        return  progress.getId().toString();
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
