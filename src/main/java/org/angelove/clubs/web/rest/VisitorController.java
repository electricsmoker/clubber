package org.angelove.clubs.web.rest;

import org.angelove.clubs.domain.Visitor;
import org.angelove.clubs.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @GetMapping("/clubs/{clubName}/visitors")
    public List<Visitor> getAllByClubName(@PathVariable String clubName) {
        return visitorService.findAllByClubName(clubName);
    }
}
