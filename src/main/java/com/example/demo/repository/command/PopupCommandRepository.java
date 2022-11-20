package com.example.demo.repository.command;

import com.example.demo.entities.Popup;
import com.example.demo.entities.PopupId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopupCommandRepository extends JpaRepository<Popup, PopupId> {
}
