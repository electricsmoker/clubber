package org.angelove.clubs.config;

import org.angelove.clubs.domain.Club;
import org.angelove.clubs.domain.Visitor;
import org.angelove.clubs.repository.ClubRepository;
import org.angelove.clubs.repository.VisitorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ClubRepository clubRepository, VisitorRepository visitorRepository) {

        return args -> {

            Club saxon = new Club();
            saxon.setName("saxon");
            Club forsage = new Club();
            forsage.setName("forsage");
            Visitor igor = new Visitor();
            igor.username("igor");
            Visitor angel = new Visitor();
            angel.username("angel");

            saxon.addVisitor(igor);
            igor.addClub(saxon);
            igor.addClub(forsage);
            forsage.addVisitor(angel);
            angel.addClub(forsage);
            angel.addClub(saxon);

            log.info("Preloading " + visitorRepository.save(igor));
            log.info("Preloading " + visitorRepository.save(angel));
            log.info("Preloading " + clubRepository.save(saxon));
            log.info("Preloading " + clubRepository.save(forsage));
        };
    }
}
