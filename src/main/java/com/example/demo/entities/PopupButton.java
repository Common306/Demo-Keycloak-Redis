package com.example.demo.entities;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "popupbutton")
public class PopupButton implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer popupButtonId;

    private String buttonLeft;

    private String buttonRight;

    @ManyToOne
    @JoinColumn(name = "language_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Language language;

    @OneToMany(mappedBy = "popupButton", cascade = CascadeType.ALL)
    private Collection<Popup> popups;

    public Integer getPopupButtonId() {
        return popupButtonId;
    }

    public void setPopupButtonId(Integer popupButtonId) {
        this.popupButtonId = popupButtonId;
    }

    public String getButtonLeft() {
        return buttonLeft;
    }

    public void setButtonLeft(String buttonLeft) {
        this.buttonLeft = buttonLeft;
    }

    public String getButtonRight() {
        return buttonRight;
    }

    public void setButtonRight(String buttonRight) {
        this.buttonRight = buttonRight;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
