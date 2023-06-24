package com.app.healthcare.healthcare_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "authority_name", length = 50, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "authorities")
    @JsonIgnore
    private Set<JwtUser> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}