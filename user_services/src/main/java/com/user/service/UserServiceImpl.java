package com.user.service;

import com.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService{


    //Fake user list.

    List<User> list= List.of(

            new User(1311,"Lakhan","5555555555"),
            new User(1312,"Bhimsen","1111111111"),
            new User(1313,"Rahul","22222222222"),
            new User(1314,"Abishek","3333333333"),
            new User(1315,"Bala","44444444444")
    );



    @Override
    public User getUser(long id) {
        User user = list.stream().filter(u -> u.getUserId() == id).findFirst().orElse(null);
        return user;
    }
}
