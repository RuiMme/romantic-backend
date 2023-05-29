package com.romantic.romanticbackend.mapper;

import com.romantic.romanticbackend.domain.Records;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordsMapper {
    public List<Records> recordsList(Records records);

    public void recordsAdd(Records records);
}
