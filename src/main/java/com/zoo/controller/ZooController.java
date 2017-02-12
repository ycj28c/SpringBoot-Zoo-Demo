package com.zoo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
@Api("Zoo Controller API") //swagger - describe the API
public class ZooController {

    @Autowired
    private IZooService zooService;
    
    @ApiOperation(value="List all the zoos", notes="") //swagger - describe the method
    @RequestMapping(method=RequestMethod.GET)
	public Map<?, ?> getZoos() {
	  return zooService.getZoosList();
	}
    
    @ApiOperation(value="Add new zoo", notes="Need provie correct animalList")
//    @ApiImplicitParams({
//        @ApiImplicitParam(name = "name", value = "The zoo name", required = true, dataType = "String"),
//        @ApiImplicitParam(name = "address", value = "The zoo address", required = true, dataType = "String"),
//        @ApiImplicitParam(name = "website", value = "The zoo website", required = true, dataType = "String"),
//        @ApiImplicitParam(name = "animalsList", value = "The animals list in the zoo", required = true, dataType = "List")
//    })
    @RequestMapping(method=RequestMethod.POST)
    public Zoo postZoos(@RequestBody Zoo zooInfo) { //@RequestBody only accept the JSON data
    	return zooService.postZoos(zooInfo);
    }
    
    @ApiOperation(value="Get the target zoo information")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Zoo getZooById(@PathVariable("id") Long id) throws ZooNullException {
    	return zooService.getZooById(id);
    }
    
    @ApiOperation(value="Update the target zoo information", notes="Need provie all zoo information")
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public Zoo putZooById(@PathVariable("id") Long id, @RequestBody Zoo zooInfo) {
    	return zooService.putZooById(id, zooInfo);
    }
    
    @ApiOperation(value="Update the target zoo information", notes="Allow to provie parts of zoo information")
    @RequestMapping(value="/{id}", method=RequestMethod.PATCH)
    public Zoo patchZooById(@PathVariable("id") Long id, @RequestBody Zoo zooInfo) throws ZooNullException {
    	return zooService.patchZooById(id, zooInfo);
    }
    
    @ApiOperation(value="Delete the target zoo")
    @ApiResponses({ //swagger - describe return status code
        @ApiResponse(code=200,message="Delete success"),
    })
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public SuccessInfo deleteZooById(@PathVariable("id") Long id) {
    	zooService.deleteZooById(id);
    	return new SuccessInfo();
    }
    
}