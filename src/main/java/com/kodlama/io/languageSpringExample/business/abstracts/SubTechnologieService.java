package com.kodlama.io.languageSpringExample.business.abstracts;

import com.kodlama.io.languageSpringExample.business.requests.subTechnologieRequest.CreateSubTechnologieRequest;
import com.kodlama.io.languageSpringExample.business.requests.subTechnologieRequest.DeleteSubtechnologieRequest;
import com.kodlama.io.languageSpringExample.business.requests.subTechnologieRequest.UpdateSubtechnologieRequest;
import com.kodlama.io.languageSpringExample.business.response.subtechnologieResponse.GetAllSubTechnologieResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SubTechnologieService {
    List<GetAllSubTechnologieResponse> getAll();
    void add(CreateSubTechnologieRequest createSubTechnologieRequest);
    void delete(DeleteSubtechnologieRequest deleteSubtechnologieRequest);
    void update(UpdateSubtechnologieRequest updateSubtechnologieRequest);
}
