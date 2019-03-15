/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

/**
 *
 * @author YOUSSEF
 */
public class CardNumberCheck {

    public boolean validate(String cardNumber) {
        String number = "1234";

        return (number == null ? cardNumber == null : number.equals(cardNumber));
    }

}
