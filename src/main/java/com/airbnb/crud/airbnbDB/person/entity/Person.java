package com.airbnb.crud.airbnbDB.person.entity;

import com.airbnb.crud.airbnbDB.enums.PersonGender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Data
@SuperBuilder
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PersonID", updatable = false, nullable = false)
    protected Long personID;

    @Column(name = "FirstName")
    protected String firstName;

    @Column(name = "LastName")
    protected String lastName;

    @Column(name = "EmailID")
    protected String emailID;

    @Column(name = "Password")
    protected String password;

    @Column(name = "Photo")
    protected String photo;

    @Column(name = "BirthDate")
    protected String birthDate;

    @Column(name = "PhoneNumber")
    protected String phoneNumber;

    @Column(name = "Gender")
    @Enumerated(EnumType.STRING)
    protected PersonGender gender;

    @Column(name = "AccountStatus")
    protected String accountStatus;
}
