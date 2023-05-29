package com.romantic.romanticbackend.service;

import com.romantic.romanticbackend.domain.Records;

import java.util.List;

public interface RecordsService {

    public List<Records> recordsList(Records records);

    public void recordsAdd(Records records);

}
