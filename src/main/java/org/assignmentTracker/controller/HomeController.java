package org.assignmentTracker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping({"/", "home"})
    String Home() {
        return "Assignment Tracker App";
    }

}
