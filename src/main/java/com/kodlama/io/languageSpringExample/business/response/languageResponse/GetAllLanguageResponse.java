package com.kodlama.io.languageSpringExample.business.response.languageResponse;

import com.kodlama.io.languageSpringExample.entities.concretes.SubTechnologie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLanguageResponse {
    private int id;
    private String name;
    private List<SubTechnologie> subTechnologies;
}
