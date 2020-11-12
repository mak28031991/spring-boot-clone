package com.airbnb.crud.db.repository;

import com.airbnb.crud.db.entity.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRwRepository extends JpaRepository<Host, Integer> {
}
