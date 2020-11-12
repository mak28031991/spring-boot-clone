package com.airbnb.crud.airbnbDB.host.repository;

import com.airbnb.crud.airbnbDB.host.entity.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRWRepository extends JpaRepository<Host, Long> {
}
