package com.airbnb.crud.airbnbDB.person.repository;

import com.airbnb.crud.airbnbDB.person.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRWRepository extends JpaRepository<Person, Integer> {
}
