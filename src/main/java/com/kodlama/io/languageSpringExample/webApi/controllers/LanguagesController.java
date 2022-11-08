package com.kodlama.io.languageSpringExample.webApi.controllers;

import com.kodlama.io.languageSpringExample.business.abstracts.LanguageService;
import com.kodlama.io.languageSpringExample.business.abstracts.SubTechnologieService;
import com.kodlama.io.languageSpringExample.business.requests.languageRequest.CreateLanguageRequest;
import com.kodlama.io.languageSpringExample.business.requests.languageRequest.DeleteLanguageRequest;
import com.kodlama.io.languageSpringExample.business.requests.languageRequest.UpdateLanguageRequest;
import com.kodlama.io.languageSpringExample.business.response.languageResponse.GetAllLanguageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private LanguageService languageService;
    private SubTechnologieService subTechnologieService;
    @Autowired
    public LanguagesController(LanguageService languageService, SubTechnologieService subTechnologieService){
        this.languageService = languageService;
        this.subTechnologieService = subTechnologieService;
    }
    @GetMapping("/getall")
    public List<GetAllLanguageResponse> getAll(){
        return  languageService.getAll();
    }
    @PostMapping("/add")
    public void add(CreateLanguageRequest createLanguageRequest){
        this.languageService.add(createLanguageRequest);
    }
    @PutMapping("/update/{id}")
    public void update(UpdateLanguageRequest updateLanguageRequest){
        this.languageService.update(updateLanguageRequest);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(DeleteLanguageRequest deleteLanguageRequest){
        this.languageService.delete(deleteLanguageRequest);
    }
}
