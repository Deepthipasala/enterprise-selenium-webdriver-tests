package com.hertz.tests;

import com.hertz.pages.LoginConfirmationPage;
import com.hertz.pages.LoginPage;
import com.hertz.pages.ReservationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReviewCarReservationTest {
    private WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    @Test
    public void loginPageTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        loginPage.loginLink();
        loginPage.enterLoginCredentials("pasaladeepthi@gmail.com", "Automation10");
        loginPage.login();
    }

    @Test (dependsOnMethods = "loginPageTest" )
    public void loginConfirmationPageTest() {
        LoginConfirmationPage loginConfirmationPage = new LoginConfirmationPage(driver);
        loginConfirmationPage.loginSuccessful();
    }

    @Test (dependsOnMethods = "loginConfirmationPageTest" )
    public void reservationPageTest() {
        ReservationPage reservationPage = new ReservationPage(driver);
        reservationPage.selectReservationsTab();
        reservationPage.selectCarReservations();
        reservationPage.enterPickUpLocation("IAD");
        reservationPage.checkAvailability();
        reservationPage.selectVehicle();
        reservationPage.continueToReview();
        reservationPage.confirmReviewPage();
    }

    @AfterTest
    public void quitBrowser() {
        this.driver.quit();
    }
}
