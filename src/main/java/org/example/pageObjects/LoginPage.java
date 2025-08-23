package org.example.pageObjects;

import org.example.utils.SeleniumActions;
import org.openqa.selenium.By;

public class LoginPage {

    SeleniumActions seleniumActions = new SeleniumActions();

    By USERNAME_TXT = By.xpath("//*[@PlaceHolder='Username']");
    By PASSWORD_TXT = By.xpath("//*[@PlaceHolder='Password']");
    By LOGIN_BTN = By.xpath("//button[normalize-space()='Login']");

    public void login(String userName, String password){
        seleniumActions.writeInELement(USERNAME_TXT, userName);
        seleniumActions.writeInELement(PASSWORD_TXT, password, 10);
        seleniumActions.clickOnElement(LOGIN_BTN, 10);
    }
}
