package com.kodlama.io.languageSpringExample.business.concretes;

import com.kodlama.io.languageSpringExample.business.abstracts.SubTechnologieService;
import com.kodlama.io.languageSpringExample.business.requests.subTechnologieRequest.CreateSubTechnologieRequest;
import com.kodlama.io.languageSpringExample.business.requests.subTechnologieRequest.DeleteSubtechnologieRequest;
import com.kodlama.io.languageSpringExample.business.requests.subTechnologieRequest.UpdateSubtechnologieRequest;
import com.kodlama.io.languageSpringExample.business.response.subtechnologieResponse.GetAllSubTechnologieResponse;
import com.kodlama.io.languageSpringExample.dataAccess.LanguageRepository;
import com.kodlama.io.languageSpringExample.dataAccess.SubTechnologiesRepository;
import com.kodlama.io.languageSpringExample.entities.concretes.Language;
import com.kodlama.io.languageSpringExample.entities.concretes.SubTechnologie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SubTechnologieManager implements SubTechnologieService {
    private SubTechnologiesRepository subTechnologiesRepository;
    private LanguageRepository languageRepository;
    @Autowired
    public SubTechnologieManager(SubTechnologiesRepository subTechnologiesRepository,LanguageRepository languageRepository){
        this.subTechnologiesRepository = subTechnologiesRepository;
        this.languageRepository = languageRepository;
    }
    @Override
    public List<GetAllSubTechnologieResponse> getAll() {
        List<SubTechnologie> subTechnologies = subTechnologiesRepository.findAll();
        List<GetAllSubTechnologieResponse> subTechnologieResponses = new ArrayList<>();
        for (SubTechnologie subTechnologie: subTechnologies){
            GetAllSubTechnologieResponse responseItem = new GetAllSubTechnologieResponse();
            responseItem.setId(subTechnologie.getId());
            responseItem.setName(subTechnologie.getName());
            subTechnologieResponses.add(responseItem);
        }
        return subTechnologieResponses;
    }

    @Override
    public void add(CreateSubTechnologieRequest createSubTechnologieRequest) {
        Language language = languageRepository.findById(createSubTechnologieRequest.getLanguageId()).get();
        SubTechnologie subTechnologie = new SubTechnologie();
        subTechnologie.setName(createSubTechnologieRequest.getName());
        subTechnologie.setLanguage(language);
        this.subTechnologiesRepository.save(subTechnologie);
    }

    @Override
    public void delete(DeleteSubtechnologieRequest deleteSubtechnologieRequest) {
        subTechnologiesRepository.deleteById(deleteSubtechnologieRequest.getId());
    }

    @Override
    public void update(UpdateSubtechnologieRequest updateSubtechnologieRequest) {
        SubTechnologie subTechnologie = subTechnologiesRepository.getById(updateSubtechnologieRequest.getId());
        subTechnologie.setName(updateSubtechnologieRequest.getName());
        this.subTechnologiesRepository.save(subTechnologie);
    }
}
