package com.example.login;

public class LoginController {
    LoginModel model;
    LoginView view;

    public LoginController(){
        model = new LoginModel();
        view = new LoginView();

        view.b.setOnAction(event -> {
            String u=view.t1.getText();
            String n=view.t2.getText();
            if(model.IsValid(u,n) ) view.l3.setText("True");
            else view.l3.setText("False");
        });

    }
}
