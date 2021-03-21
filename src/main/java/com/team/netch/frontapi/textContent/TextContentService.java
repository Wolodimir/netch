package com.team.netch.frontapi.textContent;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextContentService {
    private final TextContentRepo textContentRepo;

    public TextContentService(TextContentRepo textContentRepo) {
        this.textContentRepo = textContentRepo;
    }

    public List<TextContent> getAllTextContent() {
        return textContentRepo.findAll();
    }

}
