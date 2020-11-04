package com.carsonlius.boot.service.impl;

import com.carsonlius.boot.mapper.SystemLogDetailsMapper;
import com.carsonlius.boot.model.SystemLogDetails;
import com.carsonlius.boot.service.SystemLogDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SystemLogDetailsServiceImpl implements SystemLogDetailsService {
    @Autowired
    private SystemLogDetailsMapper systemLogDetailsMapper;

    @Override
    public SystemLogDetails queryLogById(int id) {
      return  systemLogDetailsMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateStudentById(SystemLogDetails systemLogDetails) {
        return  systemLogDetailsMapper.updateByPrimaryKeySelective(systemLogDetails);
    }
}
