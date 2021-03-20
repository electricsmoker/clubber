package org.angelove.clubs.web.rest;

import org.angelove.clubs.domain.Club;
import org.angelove.clubs.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class ClubController {

    @Autowired
    private ClubService clubService;


    @GetMapping("/clubs")
    public List<Club> getAll() {
        return clubService.getAll();
    }

    @GetMapping("/clubs/register")
    public List<Club> registerVisitor(@RequestParam String username, @RequestParam String nightClubName) {
        clubService.registerVisitorToClub(username, nightClubName);
        return getAll();
    }

    @GetMapping("/visitors/{userName}/clubs")
    public List<Club> getAllByUser(@PathVariable String userName) {
        return clubService.findAllByUsername(userName);
    }

    @GetMapping("/visitors/{userName}/clubs/unvisited")
    public List<Club> getAllNotVisitedByUser(@PathVariable String userName) {
        return clubService.findAllNotVisitetByUsername(userName);
    }
}
