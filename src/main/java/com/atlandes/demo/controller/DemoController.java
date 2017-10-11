package com.atlandes.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by XD.Wang on 2017/5/23.
 * 示例控制器
 */
@Controller
public class DemoController {

    @RequestMapping("test")
    @ResponseBody
    public String test() {
        return "success!";
    }

}
