package com.user.controller;



import com.user.entity.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") long userId){

        User u = this.userService.getUser(userId);

         List contacts = this.restTemplate.getForObject("http://localhost:8082/contact/user/"+u.getUserId(), List.class);

       u.setContacts(contacts);
        return u;

    }




}
