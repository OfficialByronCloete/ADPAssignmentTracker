package org.assignmentTracker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
@author Byron Cloete
StudNo: 214189872
Date: 26 September 2020
 */

@RestController
public class HomeController {

    @RequestMapping({"/", "home"})
    String Home() {
        return "Assignment Tracker App";
    }

}
