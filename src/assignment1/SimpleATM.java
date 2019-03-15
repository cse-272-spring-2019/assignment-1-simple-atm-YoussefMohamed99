/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author YOUSSEF
 */
public class SimpleATM extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Simple ATM");
        
        LoginPage loginPage = new LoginPage(primaryStage);
        MainMenu mainMenu = new MainMenu(primaryStage);
        Withdrawal withdrawal = new Withdrawal(primaryStage);
        Deposit deposit = new Deposit(primaryStage);
        
        loginPage.prepareScene();
        mainMenu.prepareScene();
        withdrawal.prepareScene();
        deposit.prepareScene();
        
        
        loginPage.setMainMenu(mainMenu);
        mainMenu.setLoginPage(loginPage);
        withdrawal.setMainMenu(mainMenu);
        mainMenu.setWithdrawal(withdrawal);
        deposit.setMainMenu(mainMenu);
        mainMenu.setDeposit(deposit);
        
        // set scene and begin -------------------------------------------------
        primaryStage.setScene(loginPage.getScene());
        primaryStage.show();
    }
    
}
