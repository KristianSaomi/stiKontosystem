package com.kontosystem.StiProjekt.userEntity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table
@ToString
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private Integer age;
    private String mail;
    private String password;



}
