package com.carsonlius.boot.web;

import com.carsonlius.boot.config.PosConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {
    @Value("${server.env}")
    private String serverEnv;

    @Autowired
    private PosConfig posConfig;

    @RequestMapping(value = "say")
    @ResponseBody
    public String say()
    {
        return "Hello World!";
    }

    @RequestMapping(value = "map")
    @ResponseBody
    public Map<String, Object> map()
    {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "liusen");
        return map;
    }

    @RequestMapping(value = "testRequest")
    @ResponseBody
    public Map<String, Object> testRequestParams(String name)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        return map;

    }


    
    @RequestMapping(value = "testCustomProperty")
    @ResponseBody
    public String testCustomProperties()
    {

        return posConfig.getWebsite();
    }

    @RequestMapping(value = "showJsp")
    public ModelAndView showJsp()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("showJsp");
        modelAndView.addObject("name", "jsp");
        return modelAndView;
    }


}
