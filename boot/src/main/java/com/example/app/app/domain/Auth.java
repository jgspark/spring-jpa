package com.example.app.app.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_auth")
public class Auth implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @JsonManagedReference("authName")
    @Column(nullable = false, name = "auth_name")
    private String authName;

    @Builder
    public Auth(String authName) {
        this.authName = authName;
    }

}