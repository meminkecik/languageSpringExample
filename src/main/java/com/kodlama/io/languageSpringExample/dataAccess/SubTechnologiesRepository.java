package com.kodlama.io.languageSpringExample.dataAccess;

import com.kodlama.io.languageSpringExample.entities.concretes.SubTechnologie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SubTechnologiesRepository extends JpaRepository<SubTechnologie,Integer> {
}
