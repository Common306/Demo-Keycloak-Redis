package com.example.demo.repository.query;

import com.example.demo.entities.Popup;
import com.example.demo.entities.PopupId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PopupQueryRepository extends JpaRepository<Popup, PopupId> {
    @Query(value = "select * from popup p join exception e\n" +
            "on p.exception_id = e.exception_id join language l\n" +
            "on p.language_id = l.language_id join popupbutton pt \n" +
            "on p.popup_button_id = pt.popup_button_id \n" +
            "where p.exception_id = ?1 and p.language_id = ?2", nativeQuery = true)
    Popup findByExceptionAndLanguage(int exceptionId, String languageId);
}
