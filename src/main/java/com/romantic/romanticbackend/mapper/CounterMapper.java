package com.romantic.romanticbackend.mapper;

import com.romantic.romanticbackend.domain.Counter;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CounterMapper {
    public Counter getList();
}
