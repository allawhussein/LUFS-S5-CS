package com.example.login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    LoginController C;

    @Override
    public void start(Stage stage) throws Exception {
        C = new LoginController();
        stage.setTitle("Login!");
        Scene scene = new Scene(C.view.v1, 320, 240);
        stage.setScene(scene);
        stage.show();


    }
    public static void main(String[] args) {
        launch();
    }
}
