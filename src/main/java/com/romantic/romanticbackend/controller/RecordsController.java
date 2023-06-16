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

    @GetMapping("/dateList")
    public List<Records> recordsListByDate(Records records) {
//        System.out.println(records.getDate());
        return recordsService.recordsListByDate(records);
    }

    @GetMapping("/date")
    public List<Records> recordsByDate(Records records) {
//        System.out.println(records.getDate());
        return recordsService.recordsDateList(records);
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
