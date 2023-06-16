package com.romantic.romanticbackend.service;

import com.romantic.romanticbackend.domain.Records;

import java.util.List;

public interface RecordsService {

    public List<Records> recordsList();

    public List<Records> recordsListByDate(Records records);

    public List<Records> recordsDateList(Records records);

    public void recordsAdd(Records records);

    public void recordsDel(int id);

}
