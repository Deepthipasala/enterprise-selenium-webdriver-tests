package com.hertz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "location-search")
    private WebElement pickupLocationTxt;

    @FindBy(name = "eplus-email")
    private WebElement loginIdTxt;

    @FindBy(name = "eplus-password")
    private WebElement passwordTxt;

    @FindBy(id = "signInJoinButton")
    private WebElement loginLinkBtn;

    @FindBy(xpath = "//div[@id='enterprise-login']/div/button")
    private WebElement signInBtn;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        this.driver.get("https://www.enterprise.com/en/home.html");
        driver.manage().window().maximize();
        this.wait.until(ExpectedConditions.visibilityOf(this.pickupLocationTxt));
    }

    public void loginLink() {
        this.loginLinkBtn.click();
    }

    public void enterLoginCredentials(String userName, String password){
        this.wait.until(ExpectedConditions.visibilityOf(this.loginIdTxt));
        this.loginIdTxt.sendKeys(userName);
        this.passwordTxt.sendKeys(password);
    }

    public void login() {
        this.signInBtn.click();
    }

}
