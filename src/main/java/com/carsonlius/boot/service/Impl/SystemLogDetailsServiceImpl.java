package com.carsonlius.boot.service.Impl;

import com.carsonlius.boot.model.SystemLogDetails;
import com.carsonlius.boot.service.SystemLogDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
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
