package com.example.gymapp.controller;

import com.example.gymapp.entity.User;
import com.example.gymapp.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/userRegister")
    public Map<String, Object> register(@RequestParam String username, @RequestParam String password){

        User user = new User();
        user.setMobile_txt(username);
        user.setPassword(password);

        HashMap<String, Object> map =  userService.registerUser(user);
        map.put("timestamp", String.valueOf(new Date(System.currentTimeMillis())));
        return map;
    }

    @GetMapping( value = "/userLogin")
    public Map<String, Object> userLogin(@RequestParam String username, @RequestParam String password){

        User user = new User();
        user.setMobile_txt(username);
        user.setPassword(password);

        HashMap<String, Object> map =  userService.loginUser(user);
        map.put("timestamp", String.valueOf(new Date(System.currentTimeMillis())));
        return map;
    }

    @PutMapping( value = "/forgotPassword")
    public Map<String, Object> forgotPassword(@RequestParam String username, @RequestParam String password){

        User user = new User();
        user.setMobile_txt(username);
        user.setPassword(password);

        HashMap<String, Object> map =  userService.changePassword(user);
        map.put("timestamp", String.valueOf(new Date(System.currentTimeMillis())));
        return map;
    }

    @GetMapping(value = "/getUser")
    public Map<String, Object> getUser(@RequestParam String username){

        User user = new User();
        user.setMobile_txt(username);

        HashMap<String, Object> map =  userService.getUser(user);
        map.put("timestamp", String.valueOf(new Date(System.currentTimeMillis())));
        return map;
    }

    @PutMapping( value = "/updateUser")
    public Map<String, Object> updateUser(@RequestBody HashMap<String, Object> map){

        map = userService.updateUser( new ObjectMapper().convertValue(map, User.class));
        map.put("timestamp", String.valueOf(new Date(System.currentTimeMillis())));
        return map;
    }

    /*http://192.168.29.145:8080/updateUser/getUser/?username ='VIJAY';*/

}
