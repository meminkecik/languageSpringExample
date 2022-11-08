package com.kodlama.io.languageSpringExample.business.concretes;

import com.kodlama.io.languageSpringExample.business.abstracts.LanguageService;
import com.kodlama.io.languageSpringExample.business.requests.languageRequest.CreateLanguageRequest;
import com.kodlama.io.languageSpringExample.business.requests.languageRequest.DeleteLanguageRequest;
import com.kodlama.io.languageSpringExample.business.requests.languageRequest.UpdateLanguageRequest;
import com.kodlama.io.languageSpringExample.business.response.languageResponse.GetAllLanguageResponse;
import com.kodlama.io.languageSpringExample.business.response.languageResponse.UpdateLanguageResponse;
import com.kodlama.io.languageSpringExample.dataAccess.LanguageRepository;
import com.kodlama.io.languageSpringExample.dataAccess.SubTechnologiesRepository;
import com.kodlama.io.languageSpringExample.entities.concretes.Language;
import com.kodlama.io.languageSpringExample.entities.concretes.SubTechnologie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LanguageManager implements LanguageService {
    private LanguageRepository languageRepository;
    private SubTechnologiesRepository subTechnologiesRepository;
    @Autowired
    public LanguageManager(LanguageRepository languageRepository, SubTechnologiesRepository subTechnologiesRepository){
        this.languageRepository = languageRepository;
        this.subTechnologiesRepository = subTechnologiesRepository;
    }
    @Override
    public List<GetAllLanguageResponse> getAll() {
        List<Language> languages = languageRepository.findAll();
        List<SubTechnologie> subTechnologies = subTechnologiesRepository.findAll();
        List<GetAllLanguageResponse> languageResponses = new ArrayList<>();
        for (Language language : languages){
            GetAllLanguageResponse responseItem = new GetAllLanguageResponse();
            responseItem.setId(language.getId());
            responseItem.setName(language.getName());
            List<SubTechnologie> subTechnologiesResponses = new ArrayList<>();
            for (SubTechnologie subTechnologie:subTechnologies){
                if (subTechnologie.getLanguage().getId() == language.getId()){
                    subTechnologiesResponses.add(subTechnologie);
                }
            }
            responseItem.setSubTechnologies(subTechnologiesResponses);
            languageResponses.add(responseItem);
        }
        return languageResponses;
    }

    @Override
    public void add(CreateLanguageRequest createLanguageRequest) {
        Language language = new Language();
        language.setName(createLanguageRequest.getName());
        this.languageRepository.save(language);
    }

    @Override
    public void delete(DeleteLanguageRequest deleteLanguageRequest) {
        languageRepository.deleteById(deleteLanguageRequest.getId());
    }

    @Override
    public void update(UpdateLanguageRequest updateLanguageRequest) {
        Language language = languageRepository.getById(updateLanguageRequest.getId());
        language.setName(updateLanguageRequest.getName());
        this.languageRepository.save(language);
    }
}
