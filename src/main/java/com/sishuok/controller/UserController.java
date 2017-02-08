package com.sishuok.controller;

import io.swagger.annotations.ApiOperation;

import com.sishuok.entity.User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-12-22
 * <p>Version: 1.0
 */
//@EnableAutoConfiguration
@RestController
@RequestMapping("/user2")
public class UserController {

    @RequestMapping("/{id}")
    public User view(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        user.setName("zhang");
        return user;
    }
    
    @RequestMapping("/{id}/sayhi")
    public User viewx(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        user.setName("hi");
        return user;
    }
    
    @RequestMapping("/{id}/swag")
    @ApiOperation(value="swag", notes="test test")
    public User viewy(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        user.setName("hi");
        return user;
    }

    //public static void main(String[] args) {
    //    SpringApplication.run(UserController.class);
    //}

}