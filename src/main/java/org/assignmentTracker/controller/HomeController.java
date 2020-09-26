package org.assignmentTracker.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HomeController {

    @RequestMapping({"/", "home"})
    String Home() {
        return "Assignment Tracker App";
    }
}
