package com.contact.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

    private Long cid;
    private String email;
    private String Names;
    private Long userid;
}
