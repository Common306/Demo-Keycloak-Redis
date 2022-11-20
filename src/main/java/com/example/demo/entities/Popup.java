package com.example.demo.entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "popup")
@IdClass(PopupId.class)
@ToString
public class Popup implements Serializable {

    private String title;

    private String content;

    @ManyToOne
    @JoinColumn(name = "popup_button_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private PopupButton popupButton;

    @ManyToOne
    @JoinColumn(name = "exception_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Id
    private Exception exception;

    @ManyToOne
    @JoinColumn(name = "language_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Id
    private Language language;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PopupButton getPopupButton() {
        return popupButton;
    }

    public void setPopupButton(PopupButton popupButton) {
        this.popupButton = popupButton;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
