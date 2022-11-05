package com.example.jpa.data.domain;

import com.example.jpa.data.domain.base.BaseEntity;
import com.example.jpa.data.domain.base.Name;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Table
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "students")
public class Student extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Embedded
    private Name name;

    @Builder
    private Student(String firstName, String lastName) {
        this.name = Name.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }
}
