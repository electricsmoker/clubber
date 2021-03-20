package org.angelove.clubs.repository;

import org.angelove.clubs.domain.Club;
import org.angelove.clubs.domain.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
    Optional<Club> findByName(String name);
    List<Club> findAllByVisitors_Username(String username);
    List<Club> findAllByVisitors_UsernameNot(String username);
}
