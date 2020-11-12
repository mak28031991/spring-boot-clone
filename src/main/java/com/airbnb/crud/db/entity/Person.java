package com.airbnb.crud.db.entity;

import com.airbnb.crud.db.enums.AccountStatus;
import com.airbnb.crud.db.enums.PersonGender;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Builder
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PersonID", updatable = false, nullable = false)
    private String id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "EmailID")
    private String emailId;

    @Column(name = "Password")
    private String password;

    @Column(name = "Photo")
    private String photoUrl;

    @Column(name = "BirthDate")
    private String dateOfBirth;

    @Column(name = "PhoneNumber")
    private String phone;

    @Column(name = "Gender")
    private PersonGender gender;

    @Column(name = "AccountStatus")
    private AccountStatus accountStatus;
}
