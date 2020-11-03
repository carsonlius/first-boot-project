package com.carsonlius.boot.web;

import com.carsonlius.boot.model.SystemLogDetails;
import com.carsonlius.boot.service.SystemLogDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DetailLogController {
    @Autowired
    private SystemLogDetailsService systemLogDetailsService;

    @RequestMapping(value="log")
    @ResponseBody
    public Map<String, Object> log(int logId)
    {
        SystemLogDetails logDetails = systemLogDetailsService.queryLogById(logId);

        Map<String, Object> defaultMap = new HashMap<>();
        return logDetails != null ? (Map<String, Object>) logDetails : defaultMap;
    }
}
