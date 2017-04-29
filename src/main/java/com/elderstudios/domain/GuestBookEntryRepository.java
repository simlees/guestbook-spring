package com.elderstudios.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GuestBookEntryRepository extends CrudRepository<GuestBookEntry,Long> {

//    @Query("SELECT t FROM GuestBookEntry t  WHERE t.name = :name")
    List<GuestBookEntry> findByName(String name);
}
