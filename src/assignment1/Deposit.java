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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author YOUSSEF
 */
public class Deposit {

    Stage stage;
    Scene scene;
    Transactions transactions;
    MainMenu mainMenu;
    NumberStringCheck numCheck;

    public Deposit(Stage stage) {
        this.stage = stage;
    }

    public void prepareScene() {

        transactions = new Transactions();
        numCheck = new NumberStringCheck();

        Label depositLabel = new Label("Please enter deposit amount.");
        Label validationLabel = new Label();
        Button depositButton = new Button("Deposit");
        Button mainMenuButton = new Button("Main Menu");
        TextField depositField = new TextField();

        GridPane grid = new GridPane();
        grid.add(depositLabel, 0, 0);
        grid.add(depositField, 0, 1);
        grid.add(depositButton, 0, 2);
        grid.add(validationLabel, 0, 3);
        grid.add(mainMenuButton, 0, 4);
        grid.setVgap(10);

        mainMenuButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                stage.setScene(mainMenu.getScene());
            }
        });

        depositButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String str = depositField.getText();

                boolean valid1 = numCheck.validate(str);

                if (valid1) { //checks input to be numeric.

                    Transactions.counter++;
                    double amount = Double.parseDouble(str);
                    transactions.deposit(amount);
                    validationLabel.setText("Successful transaction, $" + amount + " have been deposited.");
                    validationLabel.setFont(new Font("Arial", 18));
                    validationLabel.setTextFill(Color.web("#000000", 0.8));
                    depositField.clear();
                    transactions.historyUpdate(1, amount);
                } else {

                    validationLabel.setText("Invalid Input!!!");
                    validationLabel.setFont(new Font("Times New Roman", 20));
                    validationLabel.setTextFill(Color.web("#ff0000", 0.8));
                    depositField.clear();

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
