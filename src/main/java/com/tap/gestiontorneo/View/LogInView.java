package com.tap.gestiontorneo.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.util.Objects;

public class LogInView extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Título principal
        Label title = new Label("Inicio de Sesión");
        title.getStyleClass().addAll("h2", "text-primary");

        // Campos
        TextField usernameField = new TextField();
        usernameField.setPromptText("Usuario o correo");
        usernameField.getStyleClass().add("form-control");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Contraseña");
        passwordField.getStyleClass().add("form-control");

        // Botones
        Button loginButton = new Button("Entrar");
        loginButton.getStyleClass().addAll("btn", "btn-primary", "btn-lg");
        //loginButton.setOnAction(e -> loginController.loginFx(usernameField, passwordField));

        Button showRegisterButton = new Button("Crear cuenta");
        showRegisterButton.getStyleClass().addAll("btn", "btn-secondary");
        showRegisterButton.setOnAction(e -> abrirVentanaRegistro());

        // Layout principal
        VBox loginLayout = new VBox(15, title, usernameField, passwordField, loginButton, showRegisterButton);
        loginLayout.setAlignment(Pos.CENTER);
        loginLayout.setPadding(new Insets(30));
        loginLayout.getStyleClass().add("bg-light");

        Scene loginScene = new Scene(loginLayout, 400, 450);
        loginScene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());

        // icono
//        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icon.png")));
//        primaryStage.getIcons().add(icon);

        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Log In");
        primaryStage.show();
    }

    // Ventana de Registro
    private void abrirVentanaRegistro() {
        Label registerTitle = new Label("Registro de Usuario");
        registerTitle.getStyleClass().addAll("h3", "text-success");

        TextField fullName = new TextField();
        fullName.setPromptText("Nombre completo");
        fullName.getStyleClass().add("form-control");

        TextField regUsername = new TextField();
        regUsername.setPromptText("Nombre de usuario");
        regUsername.getStyleClass().add("form-control");

        TextField regEmail = new TextField();
        regEmail.setPromptText("Correo electrónico");
        regEmail.getStyleClass().add("form-control");

        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("Fecha de nacimiento");
        datePicker.getStyleClass().add("form-control");

        PasswordField regPassword = new PasswordField();
        regPassword.setPromptText("Contraseña");
        regPassword.getStyleClass().add("form-control");

        PasswordField confirmPassword = new PasswordField();
        confirmPassword.setPromptText("Confirmar contraseña");
        confirmPassword.getStyleClass().add("form-control");

        Button submitButton = new Button("Registrar");
        submitButton.getStyleClass().addAll("btn", "btn-success", "btn-lg");
//        submitButton.setOnAction(e -> {
//             boolean ok = registroController.registroFx(
//                   fullName, regUsername, regEmail, regPassword, confirmPassword, datePicker
//
//            if (ok) ((Stage) submitButton.getScene().getWindow()).close();
//        });

        VBox registerLayout = new VBox(12, registerTitle, fullName, regUsername, regEmail,
                datePicker, regPassword, confirmPassword, submitButton);
        registerLayout.setAlignment(Pos.CENTER);
        registerLayout.setPadding(new Insets(30));
        registerLayout.getStyleClass().add("bg-light");

        Scene registerScene = new Scene(registerLayout, 420, 520);
        registerScene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());

        //Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icon.png")));

        Stage registerStage = new Stage();
        //registerStage.getIcons().add(icon);
        registerStage.setTitle("Registro de Usuario");
        registerStage.setScene(registerScene);
        registerStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
