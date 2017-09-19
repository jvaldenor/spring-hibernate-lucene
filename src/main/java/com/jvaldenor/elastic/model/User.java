package com.jvaldenor.elastic.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Indexed
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;


    @Getter
    @Setter
    @Field
    private String username;

    @Getter
    @Setter
    @Field
    private String firstname;

    @Getter
    @Setter
    @Field
    private String lastname;

    @Getter
    @Setter
    @Field
    private String gender;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    @Field
    private Date birthDate;


}
