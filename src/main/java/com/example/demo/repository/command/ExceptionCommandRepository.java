package com.example.demo.repository.command;

import com.example.demo.entities.Exception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionCommandRepository extends JpaRepository<Exception, Integer> {
}
