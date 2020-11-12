package com.airbnb.crud.airbnbDB.host.repository;

import com.airbnb.crud.airbnbDB.annotation.ReadOnlyRepository;
import com.airbnb.crud.airbnbDB.host.entity.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@ReadOnlyRepository
public interface HostRRepository extends JpaRepository<Host, Integer> {
}
