package com.google.mapper;


import com.google.entity.CustomerEntity;
import org.apache.ibatis.type.MappedTypes;

import java.util.List;

public interface CustomerEntityMapper {

    List<CustomerEntity> selectList();
}
