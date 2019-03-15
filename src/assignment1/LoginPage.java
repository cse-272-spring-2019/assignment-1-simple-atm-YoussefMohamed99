/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author YOUSSEF
 */
public class LoginPage {

    static boolean valid2;
    Stage stage;
    Scene scene;
    CardNumberCheck check;
    NumberStringCheck numCheck;
    MainMenu mainMenu;

    public LoginPage(Stage stage) {
        this.stage = stage;
    }

    public void prepareScene() {

        // configuration--------------------------------------------------------
        check = new CardNumberCheck();
        numCheck = new NumberStringCheck();

        // drawing--------------------------------------------------------------
        Label cardNumberLabel = new Label("  Please enter card number.");
        PasswordField cardNumberField = new PasswordField();
        Button login = new Button("Log In");
        Label validationLabel = new Label();

        GridPane grid = new GridPane();
        grid.add(cardNumberLabel, 0, 0);
        grid.add(cardNumberField, 0, 1);
        grid.add(login, 0, 2);
        grid.add(validationLabel, 0, 3);
        grid.setVgap(10);

        // registering actions--------------------------------------------------
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String str = cardNumberField.getText();

                boolean valid1 = numCheck.validate(str);
                valid2 = check.validate(str);

                if (valid1) { //checks input to be numeric.

                    if (valid2) {//checks wheather card number is correct or not

                        validationLabel.setText("Welcome Mr. Youssef");
                        validationLabel.setFont(new Font("Arial", 18));
                        validationLabel.setTextFill(Color.web("#000000", 0.8));
                        cardNumberField.clear();
                        stage.setScene(mainMenu.getScene());
                    } else {
                        validationLabel.setText("Invalid Card Number, please enter a valid number.");
                        validationLabel.setFont(new Font("Times New Roman", 20));
                        validationLabel.setTextFill(Color.web("#ff0000", 0.8));
                        cardNumberField.clear();
                    }
                } else {

                    validationLabel.setText("Invalid Input!!!");
                    validationLabel.setFont(new Font("Times New Roman", 20));
                    validationLabel.setTextFill(Color.web("#ff0000", 0.8));
                    cardNumberField.clear();
                }

            }
        });

        scene = new Scene(grid, 600, 400);
    }

    public Scene getScene() {
        return scene;
    }

    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

}
