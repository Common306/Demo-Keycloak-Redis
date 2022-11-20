package com.example.demo.repository.command;

import com.example.demo.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageCommandRepository extends JpaRepository<Language, String> {
}
