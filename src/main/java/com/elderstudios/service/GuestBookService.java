package com.elderstudios.service;

import com.elderstudios.domain.GuestBookEntry;
import com.elderstudios.domain.GuestBookEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestBookService {

    @Autowired
    protected GuestBookEntryRepository guestBookEntryRepository;

    public Iterable<GuestBookEntry> findAll() {
        return guestBookEntryRepository.findAll();
//        List<GuestBookEntry> elements = Lists.newArrayList( guestBookEntryRepository.findAll() );
//        return elements;
    }

    public List<GuestBookEntry> findByName(String name) {
        return guestBookEntryRepository.findByName(name);
    }

    public GuestBookEntry save(GuestBookEntry entry) {
        return guestBookEntryRepository.save(entry);
    }

    public void delete(GuestBookEntry entry) { guestBookEntryRepository.delete(entry); }
}
