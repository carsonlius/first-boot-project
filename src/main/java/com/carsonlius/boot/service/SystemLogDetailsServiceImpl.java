package com.carsonlius.boot.service;

import com.carsonlius.boot.mapper.SystemLogDetailsMapper;
import com.carsonlius.boot.model.SystemLogDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SystemLogDetailsServiceImpl implements SystemLogDetailsService {
    @Autowired
    private SystemLogDetailsMapper systemLogDetailsMapper;

    @Override
    public SystemLogDetails queryLogById(int id) {
      return  systemLogDetailsMapper.selectByPrimaryKey(id);
    }
}
