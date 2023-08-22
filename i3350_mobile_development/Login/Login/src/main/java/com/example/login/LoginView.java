package com.example.login;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class LoginView {
    TextField t1;
    TextField t2;
    Button b;
    Label l1;
    Label l2,l3;
    HBox h1,h2;
    VBox v1;
    public LoginView(){
        h1 = new HBox();
        h2 = new HBox();
        v1 = new VBox();


        l1 = new Label("Username:");
        t1 = new TextField();
        h1.getChildren().addAll(l1,t1);


        l2 = new Label("Password:");
        t2=new TextField();
        h2.getChildren().addAll(l2,t2);


        b=new Button();
        b.setText("Login");
        l3=new Label("");
        v1.getChildren().addAll(h1,h2,b,l3);

    }
}
