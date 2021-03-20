package org.angelove.clubs.repository;

import org.angelove.clubs.domain.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {
    Optional<Visitor> findByUsername(String username);
    List<Visitor> findAllByClubs_Name(String clubName);
}
