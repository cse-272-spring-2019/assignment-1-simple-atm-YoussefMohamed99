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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author YOUSSEF
 */
public class Withdrawal {

    static boolean valid2;
    Stage stage;
    Scene scene;
    Transactions transactions;
    MainMenu mainMenu;
    NumberStringCheck numCheck;

    public Withdrawal(Stage stage) {
        this.stage = stage;
    }

    public void prepareScene() {

        transactions = new Transactions();
        numCheck = new NumberStringCheck();

        Label withdrawalLabel = new Label("Please enter amount to be withdrawn.");
        Label validationLabel = new Label();
        Button withdrawButton = new Button("Withdraw");
        Button mainMenuButton = new Button("Main Menu");
        TextField withdrawalField = new TextField();

        GridPane grid = new GridPane();
        grid.add(withdrawalLabel, 0, 0);
        grid.add(withdrawalField, 0, 1);
        grid.add(withdrawButton, 0, 2);
        grid.add(validationLabel, 0, 3);
        grid.add(mainMenuButton, 0, 4);
        grid.setVgap(10);

        mainMenuButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                stage.setScene(mainMenu.getScene());
            }
        });

        withdrawButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String str = withdrawalField.getText();

                boolean valid1 = numCheck.validate(str);

                if (valid1) { //checks input to be numeric.

                    double amount = Double.parseDouble(str);
                    valid2 = transactions.withdraw(amount);
                    if (valid2) { //checks if balance is sufficient.

                        Transactions.counter++;
                        validationLabel.setText("Successful transaction, $" + amount + " have been withdrawn.");
                        validationLabel.setFont(new Font("Arial", 18));
                        validationLabel.setTextFill(Color.web("#000000", 0.8));
                        transactions.historyUpdate(2, amount);
                        withdrawalField.clear();
                    } else {

                        validationLabel.setText("Insufficient Balance!!!");
                        validationLabel.setFont(new Font("Times New Roman", 20));
                        validationLabel.setTextFill(Color.web("#ff0000", 0.8));
                        withdrawalField.clear();
                    }
                } else {

                    validationLabel.setText("Invalid Input!!!");
                    validationLabel.setFont(new Font("Times New Roman", 20));
                    validationLabel.setTextFill(Color.web("#ff0000", 0.8));
                    withdrawalField.clear();

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
