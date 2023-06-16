package com.romantic.romanticbackend.service.impl;

import com.romantic.romanticbackend.domain.Records;
import com.romantic.romanticbackend.mapper.RecordsMapper;
import com.romantic.romanticbackend.service.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RecordsServiceImpl implements RecordsService {

    @Autowired
    private RecordsMapper recordsMapper;

    @Override
    public List<Records> recordsList(){
        return recordsMapper.recordsList();
    }

    @Override
    public List<Records> recordsListByDate(Records records){
        return recordsMapper.recordsListByDate(records);
    }

    @Override
    public List<Records> recordsDateList(Records records) {
        return recordsMapper.recordsDateList(records);
    }

    @Override
    public void recordsAdd(Records records){
        Date date = new Date();
        records.setCreateAt(date);
        records.setDeleted(0);
        recordsMapper.recordsAdd(records);
    }

    @Override
    public void recordsDel(int id){
        recordsMapper.recordsDel(id);
    }
}
