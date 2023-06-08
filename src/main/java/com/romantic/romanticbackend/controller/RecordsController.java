package com.romantic.romanticbackend.controller;

import com.romantic.romanticbackend.domain.Records;
import com.romantic.romanticbackend.service.RecordsService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/app/romantic/records")
public class RecordsController {

    @Autowired
    private RecordsService recordsService;

    @GetMapping("/list")
    public List<Records> recordsList() {
//        System.out.println(records.getDate());
        return recordsService.recordsList();
    }

    @GetMapping(value = "/{date}")
    public List<Records> recordsListByDate(@PathVariable("date") String date) {
//        System.out.println(records.getDate());
        return recordsService.recordsListByDate(date);
    }

    @GetMapping(value = "/date")
    public List<Records> recordsListByDate() {
//        System.out.println(records.getDate());
        return recordsService.recordsDateList();
    }

    @PostMapping
    public String recordsAdd(@RequestBody Records records) {

        recordsService.recordsAdd(records);

        return "insert success";
    }

    @DeleteMapping("/{ids}")
    public String recordsDel(@PathVariable int ids){
        recordsService.recordsDel(ids);
        return "success";
    }
}
