package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private long userId;
    private String name;
    private String phone;


    List<Contact> contacts=new ArrayList<>();

    public User(long l, String n, String p) {
        this.userId = l;
        this.name = n;
        this.phone = p;
    }
}
