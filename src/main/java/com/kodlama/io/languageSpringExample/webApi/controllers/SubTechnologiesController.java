package com.kodlama.io.languageSpringExample.webApi.controllers;

import com.kodlama.io.languageSpringExample.business.abstracts.SubTechnologieService;
import com.kodlama.io.languageSpringExample.business.requests.languageRequest.DeleteLanguageRequest;
import com.kodlama.io.languageSpringExample.business.requests.languageRequest.UpdateLanguageRequest;
import com.kodlama.io.languageSpringExample.business.requests.subTechnologieRequest.CreateSubTechnologieRequest;
import com.kodlama.io.languageSpringExample.business.requests.subTechnologieRequest.DeleteSubtechnologieRequest;
import com.kodlama.io.languageSpringExample.business.requests.subTechnologieRequest.UpdateSubtechnologieRequest;
import com.kodlama.io.languageSpringExample.business.response.subtechnologieResponse.GetAllSubTechnologieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/subtechnologies")
public class SubTechnologiesController {
    private SubTechnologieService subTechnologieService;
    @Autowired
    public SubTechnologiesController(SubTechnologieService subTechnologieService){
        this.subTechnologieService = subTechnologieService;
    }
    @GetMapping("/getall")
    public List<GetAllSubTechnologieResponse> getAll(){
        return  subTechnologieService.getAll();
    }
    @PostMapping("/add")
    public void add(CreateSubTechnologieRequest createSubTechnologieRequest){
        this.subTechnologieService.add(createSubTechnologieRequest);
    }
    @PutMapping("/update/{id}")
    public void update(UpdateSubtechnologieRequest updateSubtechnologieRequest){
        this.subTechnologieService.update(updateSubtechnologieRequest);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(DeleteSubtechnologieRequest deleteSubtechnologieRequest){
        this.subTechnologieService.delete(deleteSubtechnologieRequest);
    }
}
