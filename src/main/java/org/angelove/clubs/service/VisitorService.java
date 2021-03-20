package org.angelove.clubs.service;

import org.angelove.clubs.domain.Visitor;
import org.angelove.clubs.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitorService {
    @Autowired
    private VisitorRepository visitorRepository;

    public Optional<Visitor> findByName(String username) {
        return visitorRepository.findByUsername(username);
    }

    public Visitor save(Visitor entity) {
        return visitorRepository.saveAndFlush(entity);
    }

    public List<Visitor> findAllByClubName(String clubName) {
        return visitorRepository.findAllByClubs_Name(clubName);
    }
}
