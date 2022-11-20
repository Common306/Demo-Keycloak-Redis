package com.example.demo.repository.command;

import com.example.demo.entities.PopupButton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopupButtonCommandRepository extends JpaRepository<PopupButton, Integer> {
}
