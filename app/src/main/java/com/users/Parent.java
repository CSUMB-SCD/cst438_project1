package com.users;

/**
 * Created by sboyd on 10/8/2017.
 */

public class Parent extends User{

    String username;
    String password;
    String email;

    public Parent(String username, String password, String email)
    {
        super(username,password,email);
    }
}
