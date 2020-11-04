package com.carsonlius.boot.service;

import com.carsonlius.boot.model.SystemLogDetails;

public interface SystemLogDetailsService {
    com.carsonlius.boot.model.SystemLogDetails queryLogById(int id);

    int updateStudentById(SystemLogDetails systemLogDetails);
}
