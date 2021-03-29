package com.team.netch.frontapi.imageContent;

import com.team.netch.amazon.AmazonClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class ImageContentService {

    private final AmazonClient amazonClient;
    private final ImageContentRepo imageContentRepo;

    public ImageContentService(AmazonClient amazonClient, ImageContentRepo imageContentRepo) {
        this.amazonClient = amazonClient;
        this.imageContentRepo = imageContentRepo;
    }

    public List<ImageContent> getImageContentByName(String name){
        return imageContentRepo.findByName(name);
    }

    public List<ImageContent> getAllImageContent(){
        return imageContentRepo.findAll();
    }

    public void saveImageContent(MultipartFile multipartFile, String name, String header, String body){
        ImageContent imageContent = new ImageContent();
        imageContent.setName(name);
        imageContent.setHeader(header);
        imageContent.setBody(body);
        imageContent.setImageUrl(amazonClient.uploadFile(multipartFile));
        imageContentRepo.save(imageContent);
    }

    public void deleteImageContentById(Long id){
        if(!imageContentRepo.existsById(id)){
            throw new IllegalStateException("Content with id " + id + " does not exists");
        }
        Optional<ImageContent> imageContent = imageContentRepo.findById(id);
        amazonClient.deleteFileFroms3Bucket(imageContent.get().getImageUrl());

        imageContentRepo.deleteById(id);
    }







}
