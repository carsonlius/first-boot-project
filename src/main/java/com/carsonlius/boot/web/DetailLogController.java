package com.carsonlius.boot.web;

import com.carsonlius.boot.model.SystemLogDetails;
import com.carsonlius.boot.service.SystemLogDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author carsonlius
 */
@Controller
public class DetailLogController {
    @Autowired
    private SystemLogDetailsService systemLogDetailsService;

    @RequestMapping(value="log")
    @ResponseBody
    public SystemLogDetails log(int logId)
    {
        SystemLogDetails systemLogDetails =   systemLogDetailsService.queryLogById(logId);

        System.out.println(systemLogDetails);
        return systemLogDetails;
    }
}
