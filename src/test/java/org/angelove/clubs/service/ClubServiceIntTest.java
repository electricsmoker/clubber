package org.angelove.clubs.service;

import org.angelove.clubs.ClubsApplication;
import org.angelove.clubs.domain.Club;
import org.angelove.clubs.domain.Visitor;
import org.angelove.clubs.repository.ClubRepository;
import org.angelove.clubs.repository.VisitorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;


@SpringBootTest(classes = ClubsApplication.class)
public class ClubServiceIntTest {

    @Autowired
    private ClubService clubService;

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private VisitorRepository visitorRepository;

    @Test
    public void createClub() {
        Club club = new Club();
        club.setName("FORSAGE");
        List<Club> resultBefore = clubRepository.findAll();
        clubService.saveClub(club);
        List<Club> resultAfter = clubRepository.findAll();
        assertThat(resultAfter.size()).isEqualTo(resultBefore.size() + 1);
    }
}
