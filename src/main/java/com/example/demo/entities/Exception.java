package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "exception")
public class Exception implements Serializable {
    @Id
    private Integer exceptionId;
    private String description;

    @OneToMany(mappedBy = "exception", cascade = CascadeType.ALL)
    private Collection<Popup> popups;

    public Integer getExceptionId() {
        return exceptionId;
    }

    public void setExceptionId(Integer exceptionId) {
        this.exceptionId = exceptionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
