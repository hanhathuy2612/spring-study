package com.huy.spring_study.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Table(name = "permission")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Permission implements Serializable {
    @Id
    private String name;
}
