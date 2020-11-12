package com.airbnb.crud.db.repository;

import com.airbnb.crud.db.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRWRepository extends JpaRepository<Person, Integer> {
}
