package com.kodlama.io.languageSpringExample.dataAccess;

import com.kodlama.io.languageSpringExample.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language,Integer> {
}
