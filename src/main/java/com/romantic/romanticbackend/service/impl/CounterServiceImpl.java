package com.romantic.romanticbackend.service.impl;

import com.romantic.romanticbackend.domain.Counter;
import com.romantic.romanticbackend.mapper.CounterMapper;
import com.romantic.romanticbackend.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounterServiceImpl implements CounterService {

    @Autowired
    private CounterMapper counterMapper;
    @Override
    public Counter getList() {
        return counterMapper.getList();
    }

}
