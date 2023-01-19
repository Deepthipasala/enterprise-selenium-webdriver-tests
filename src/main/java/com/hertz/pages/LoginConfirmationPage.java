package com.hertz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[@aria-label = 'My Rentals']")
    private WebElement myRentalsLink;

    @FindBy(xpath = "//span[@class='label' and text()='Hi, TEST']")
    private WebElement loginNameTxt;
    public LoginConfirmationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void loginSuccessful(){
        this.wait.until(ExpectedConditions.visibilityOf(this.myRentalsLink));
        this.loginNameTxt.click();
    }

}
