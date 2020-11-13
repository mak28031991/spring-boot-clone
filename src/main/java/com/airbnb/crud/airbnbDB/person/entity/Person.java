package com.airbnb.crud.airbnbDB.person.entity;

import com.airbnb.crud.airbnbDB.enums.AccountStatus;
import com.airbnb.crud.airbnbDB.enums.PersonGender;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Data
@Builder
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PersonID", updatable = false, nullable = false)
    private Long personID;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "EmailID")
    private String emailID;

    @Column(name = "Password")
    private String password;

    @Column(name = "Photo")
    private String photo;

    @Column(name = "BirthDate")
    private String birthDate;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "Gender")
    private PersonGender gender;

    @Column(name = "AccountStatus")
    private AccountStatus accountStatus;
}
