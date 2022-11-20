package com.example.demo.repository.query;

import com.example.demo.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageQueryRepository extends JpaRepository<Language, String> {
}
