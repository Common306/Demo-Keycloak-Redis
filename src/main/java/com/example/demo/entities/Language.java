package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "language")
public class Language implements Serializable {
    @Id
    private String languageId;

    private String description;

    @OneToMany(mappedBy = "language", cascade = CascadeType.ALL)
    private Collection<Popup> popups;

    @OneToMany(mappedBy = "language", cascade = CascadeType.ALL)
    private Collection<PopupButton> popupButtons;

    public String getLanguageId() {
        return languageId;
    }

    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
