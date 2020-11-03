package com.carsonlius.boot.mapper;

import com.carsonlius.boot.model.SystemLogDetails;

public interface SystemLogDetailsMapper {
    int deleteByPrimaryKey(Integer recId);

    int insert(SystemLogDetails record);

    int insertSelective(SystemLogDetails record);

    SystemLogDetails selectByPrimaryKey(Integer recId);

    int updateByPrimaryKeySelective(SystemLogDetails record);

    int updateByPrimaryKeyWithBLOBs(SystemLogDetails record);

    int updateByPrimaryKey(SystemLogDetails record);
}