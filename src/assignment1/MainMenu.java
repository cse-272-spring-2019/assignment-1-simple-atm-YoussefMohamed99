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
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author YOUSSEF
 */
public class MainMenu {

    Stage stage;
    Scene scene;
    Transactions transactions;
    LoginPage loginPage;
    Withdrawal withdrawal;
    Deposit deposit;

    public MainMenu(Stage stage) {
        this.stage = stage;
    }

    public void prepareScene() {

        transactions = new Transactions();

        Label statusLabel = new Label("  Account details.");
        Button withdrawButton = new Button("Withdraw");
        Button depositButton = new Button("Deposit");
        Button balanceInquiryButton = new Button("Balance Inquiry");
        Button previousButton = new Button("Previous");
        Button nextButton = new Button("Next");
        Button logout = new Button("Log Out");

        GridPane grid = new GridPane();
        grid.add(depositButton, 2, 0);
        grid.add(withdrawButton, 0, 0);
        grid.add(balanceInquiryButton, 0, 1);
        grid.add(previousButton, 0, 2);
        grid.add(nextButton, 2, 2);
        grid.add(logout, 1, 3);
        grid.add(statusLabel, 1, 1);
        grid.setVgap(10);
        grid.setHgap(10);

        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(loginPage.getScene());
            }
        });

        withdrawButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(withdrawal.getScene());
            }
        });

        depositButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(deposit.getScene());
            }
        });

        balanceInquiryButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Transactions.counter++;
                statusLabel.setText("Your current balance is $" + transactions.balanceInquiry());
                statusLabel.setFont(new Font("Arial", 18));
                statusLabel.setTextFill(Color.web("#000000", 0.8));
                transactions.historyUpdate(0, Transactions.balance);
            }
        });

        previousButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (Transactions.counter < 0) { //

                    statusLabel.setText("No previous saved history!!!");
                    statusLabel.setFont(new Font("Times New Roman", 20));
                    statusLabel.setTextFill(Color.web("#ff0000", 0.8));

                } else {

                    if (Transactions.counter == 0) {

                        statusLabel.setText(Transactions.history[Transactions.counter]);//
                        statusLabel.setFont(new Font("Arial", 18));
                        statusLabel.setTextFill(Color.web("#000000", 0.8));
                        Transactions.counter--;
                    } else if (Transactions.counter != 0) {
                        
                        statusLabel.setText(Transactions.history[Transactions.counter]);//
                        statusLabel.setFont(new Font("Arial", 18));
                        statusLabel.setTextFill(Color.web("#000000", 0.8));
                        Transactions.counter--;//
                    }
                }
            }
        });

        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (Transactions.counter == -1) {
                    Transactions.counter = 0;

                }
                if (Transactions.counter > 500) {

                    statusLabel.setText("End of history!!!");
                    statusLabel.setFont(new Font("Times New Roman", 20));
                    statusLabel.setTextFill(Color.web("#ff0000", 0.8));
                    while (Transactions.history[Transactions.counter] != null) {

                        Transactions.counter--;
                    }
                }
                if (Transactions.history[Transactions.counter] == null) {

                    statusLabel.setText("End of history!!!");
                    statusLabel.setFont(new Font("Times New Roman", 20));
                    statusLabel.setTextFill(Color.web("#ff0000", 0.8));
                } else {

                    statusLabel.setText(Transactions.history[Transactions.counter]);//
                    statusLabel.setFont(new Font("Arial", 18));
                    statusLabel.setTextFill(Color.web("#000000", 0.8));
                    Transactions.counter++;//
                }

            }
        });

        scene = new Scene(grid, 600, 400);
    }

    public Scene getScene() {
        return scene;
    }

    public void setLoginPage(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public void setWithdrawal(Withdrawal withdrawal) {
        this.withdrawal = withdrawal;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

}
