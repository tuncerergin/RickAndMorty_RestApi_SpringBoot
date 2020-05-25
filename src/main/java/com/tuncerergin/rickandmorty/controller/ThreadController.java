package com.tuncerergin.rickandmorty.controller;

import com.tuncerergin.rickandmorty.service.ThreadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ThreadController {

    public final ThreadService threadService;

    public ThreadController(ThreadService threadService) {
        this.threadService = threadService;
    }

    @GetMapping("/thread-demo")
    public String thread(Model theModel) {
        // Start the clock
        long start = System.currentTimeMillis();
        /* @TODO
         *    add thread here
         * */
        return "thread";
    }
}
