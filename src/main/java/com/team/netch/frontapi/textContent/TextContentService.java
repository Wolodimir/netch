package com.team.netch.frontapi.textContent;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextContentService {
    private final TextContentRepo textContentRepo;

    public TextContentService(TextContentRepo textContentRepo) {
        this.textContentRepo = textContentRepo;
    }

    public void deleteTextContentById(Long id){
        textContentRepo.deleteById(id);
    }

    public List<TextContent> getAllTextContent() {
        return textContentRepo.findAll();
    }

    public void save(TextContent textContent) {
        textContentRepo.save(textContent);
    }

    public List<TextContent> getTextContentByName(String name) {
        return textContentRepo.findByName(name);
    }
}
