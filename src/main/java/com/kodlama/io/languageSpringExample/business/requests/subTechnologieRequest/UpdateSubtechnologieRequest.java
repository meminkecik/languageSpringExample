package com.kodlama.io.languageSpringExample.business.requests.subTechnologieRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSubtechnologieRequest {
    private int id;
    private String name;
}
