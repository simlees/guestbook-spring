package com.elderstudios.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestBookEntryRepository extends JpaRepository<GuestBookEntry,Long> {}
