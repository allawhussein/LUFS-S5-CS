package com.example.login;

public class LoginModel {
    private String User_name="q";
    private String Password="q";


     boolean IsValid(String User_name,String Password)
    {
        if(this.User_name.equals(User_name) && this.Password.equals(Password)) return true;
        else return false;
    }
}
