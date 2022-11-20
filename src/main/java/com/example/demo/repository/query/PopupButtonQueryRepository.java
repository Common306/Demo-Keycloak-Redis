package com.example.demo.repository.query;

import com.example.demo.entities.PopupButton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopupButtonQueryRepository extends JpaRepository<PopupButton, Integer> {
}
