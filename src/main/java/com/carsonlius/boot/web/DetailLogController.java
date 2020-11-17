package com.carsonlius.boot.web;

import com.carsonlius.boot.model.SystemLogDetails;
import com.carsonlius.boot.service.SystemLogDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author carsonlius
 */
@RestController
@Slf4j
public class DetailLogController {
    @Autowired
    private SystemLogDetailsService systemLogDetailsService;


    @GetMapping(value="logs/{logId}")
    public SystemLogDetails  getLogDetail (@PathVariable("logId") Integer logId)
    {
        SystemLogDetails systemLogDetails =   systemLogDetailsService.queryLogById(logId);
        log.info("打印正常信息 ==========>" + systemLogDetails);
        log.error("打印错误信息 ==========>" + systemLogDetails);

        return systemLogDetails;
    }

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

    @GetMapping(value = "setRedis")
    public Map<String, Object> setRedis()
    {
        systemLogDetailsService.cacheRedis("name", "liusen");

        Map<String, Object> response = new HashMap<>();
        response.put("code", 0);
        response.put("message", "success");
        return response;
    }

    @GetMapping(value="/login")
    public Object login(HttpServletRequest httpServletRequest)
    {
        SystemLogDetails systemLogDetails =   systemLogDetailsService.queryLogById(1);
        httpServletRequest.getSession().setAttribute("log", systemLogDetails);

        return "登录成功";
    }

    @GetMapping(value = "/errorJsp")
    public Object error()
    {
        return "异常";
    }
}
