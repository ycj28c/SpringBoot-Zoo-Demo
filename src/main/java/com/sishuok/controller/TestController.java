package com.sishuok.controller;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/test")
public class TestController {

    @ResponseBody
    @RequestMapping(value = "/show", method=RequestMethod.POST)
    @ApiOperation(value="测试接口", notes="测试接口详细描述")
    public String show(
            @ApiParam(required=true, name="name", value="姓名")
            @RequestParam() String stuName){
        return "success";
    }
    
    @ResponseBody
    @RequestMapping(value = "/showx")
    @ApiOperation(value="测试接口", notes="测试接口详细描述")
    public String showx(
            @ApiParam(required=true, name="name", value="姓名")
            @RequestParam() String stuName){
        return "success";
    }
}