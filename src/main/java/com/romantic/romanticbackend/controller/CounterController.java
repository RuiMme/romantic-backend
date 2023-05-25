package com.romantic.romanticbackend.controller;

import com.romantic.romanticbackend.domain.Counter;
import com.romantic.romanticbackend.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/romantic/counter")
public class CounterController {

    @Autowired
    private CounterService counterService;

    @GetMapping("/get-list")
    public Counter getList() {
//        System.out.println("is true");
        return counterService.getList();
    }

}
