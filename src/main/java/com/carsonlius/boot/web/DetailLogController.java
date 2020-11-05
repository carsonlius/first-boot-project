package com.carsonlius.boot.web;

import com.carsonlius.boot.model.SystemLogDetails;
import com.carsonlius.boot.service.SystemLogDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author carsonlius
 */
//@Controller
@RestController
public class DetailLogController {
    @Autowired
    private SystemLogDetailsService systemLogDetailsService;

    @GetMapping(value="log/{logId}")
    public SystemLogDetails log(@PathVariable("logId") Integer logId)
    {
        SystemLogDetails systemLogDetails =   systemLogDetailsService.queryLogById(logId);

        System.out.println(systemLogDetails);
        return systemLogDetails;
    }

    @GetMapping(value = "update/{id}/{remark}")
    public Map<String, Object> update( @PathVariable String remark, @PathVariable Integer id)
    {
        SystemLogDetails systemLogDetails = new SystemLogDetails();
        systemLogDetails.setRecId(id);
        systemLogDetails.setRemark(remark);


       int updateCount = systemLogDetailsService.updateStudentById(systemLogDetails);


       Map<String, Object> response = new HashMap<>();
       response.put("status", 0);
       response.put("count", updateCount);
       response.put("message", "更新成功");
       return response;
    }
}
