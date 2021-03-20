package org.angelove.clubs.service;

import org.angelove.clubs.domain.Club;
import org.angelove.clubs.domain.Visitor;
import org.angelove.clubs.repository.ClubRepository;
import org.angelove.clubs.service.util.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {

    private final static Logger LOG = LoggerFactory.getLogger(ClubService.class);

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private VisitorService visitorService;

    public Club saveClub(Club club) {
        LOG.info("### Save Club");
        return clubRepository.save(club);
    }

    public List<Club> getAll() {
        LOG.info("### Get all");
        return clubRepository.findAll();
    }

    public void registerVisitorToClub(String visitorName, String clubName) {

        LOG.info("### Register Visitor {} to Club {}", visitorName, clubName);

        Club club = clubRepository.findByName(clubName).orElseGet(() -> new Club().name(clubName));
        Visitor visitor = visitorService.findByName(visitorName).orElseGet(() -> new Visitor().username(visitorName));
        club.addVisitor(visitor);
        visitor.addClub(club);
        visitorService.save(visitor);
        clubRepository.saveAndFlush(club);
    }


    public List<Club> findAllByUsername(String userName) {
        return clubRepository.findAllByVisitors_Username(userName);
    }

    public List<Club> findAllNotVisitetByUsername(String userName) {
        return clubRepository.findAllByVisitors_UsernameNot(userName);
    }
}
