package com.samsung.demoprj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
    //1. create logger
    Logger logger = LoggerFactory.getLogger(LogController.class);
    @GetMapping("/Error")
    public String Error()
    {
        //2. Write log tuong ung voi Level
        logger.info("This is information content");
        logger.trace("This is trace content");
        logger.warn("This is warning!");
        logger.error("This is error from application");

        return "Error success";
    }
}
