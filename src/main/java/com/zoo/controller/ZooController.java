package com.zoo.controller;

import io.swagger.annotations.Api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.entity.Zoo;
import com.zoo.service.IZooService;
import com.zoo.service.exception.SuccessInfo;
import com.zoo.service.exception.ZooNullException;

/**
 * swagger annotation detail: https://github.com/swagger-api/swagger-core/wiki/Annotations#apimodel 
 */

@RestController
@RequestMapping("/zoos")
@Api("Zoo Controller API") //describe the API
public class ZooController {

    @Autowired
    private IZooService zooService;
    
//    @Autowired
//    private MyRedisTemplate myRedisTemplate;

//    @ApiOperation("List all the zoos") //swagger - what is this method doing
//    @ApiImplicitParams({ //swagger - 
//        @ApiImplicitParam(paramType="header",name="username",dataType="String",required=true,value="用户的姓名",defaultValue="zhaojigang"),
//        @ApiImplicitParam(paramType="query",name="password",dataType="String",required=true,value="用户的密码",defaultValue="wangna")
//    })
//    @ApiResponses({ //swagger - describe code meaning
//        @ApiResponse(code=400,message="请求参数没填好"),
//        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
//    })
    @RequestMapping(method=RequestMethod.GET)
	public Map<?, ?> getZoos() {
	  return zooService.getZoosList();
	}
    
    @RequestMapping(method=RequestMethod.POST)
    public Zoo postZoos(@RequestBody Zoo zooInfo) { //@RequestBody only accept the JSON data
    	return zooService.postZoos(zooInfo);
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Zoo getZooById(@PathVariable("id") Long id) throws ZooNullException {
    	return zooService.getZooById(id);
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public Zoo putZooById(@PathVariable("id") Long id, @RequestBody Zoo zooInfo) {
    	return zooService.putZooById(id, zooInfo);
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.PATCH)
    public Zoo patchZooById(@PathVariable("id") Long id, @RequestBody Zoo zooInfo) throws ZooNullException {
    	return zooService.patchZooById(id, zooInfo);
    }
    
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public SuccessInfo deleteZooById(@PathVariable("id") Long id) {
    	zooService.deleteZooById(id);
    	return new SuccessInfo();
    }
    
}