package com.kodlama.io.languageSpringExample.business.abstracts;

import com.kodlama.io.languageSpringExample.business.requests.languageRequest.CreateLanguageRequest;
import com.kodlama.io.languageSpringExample.business.requests.languageRequest.DeleteLanguageRequest;
import com.kodlama.io.languageSpringExample.business.requests.languageRequest.UpdateLanguageRequest;
import com.kodlama.io.languageSpringExample.business.response.languageResponse.GetAllLanguageResponse;
import com.kodlama.io.languageSpringExample.business.response.languageResponse.UpdateLanguageResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LanguageService {
    List<GetAllLanguageResponse> getAll();
    void add(CreateLanguageRequest createLanguageRequest);
    void delete(DeleteLanguageRequest deleteLanguageRequest);
    void update(UpdateLanguageRequest updateLanguageRequest);
}
