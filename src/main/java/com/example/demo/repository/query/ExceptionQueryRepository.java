package com.example.demo.repository.query;

import com.example.demo.entities.Exception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionQueryRepository extends JpaRepository<Exception, Integer> {
}
