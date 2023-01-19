package com.hertz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReservationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@aria-controls='navContentReservations']")
    private WebElement reservationPage;

    @FindBy(xpath = "//a[@class='primary-nav-link']/span[text()='Start a Car Reservation']")
    private WebElement carReservationPage;

    @FindBy(id = "pickupLocationTextBox")
    private WebElement pickUpLocationTxt;

    @FindBy(xpath = "(//small[@class='location-group__item-select'])[1]")
    private WebElement airportLocation;

    @FindBy(id = "continueButton")
    private WebElement checkAvailabilityBtn;

    @FindBy(xpath = "(//button[@class='cta cta--primary cta--large cta--noMargin'])[1]")
    private WebElement selectVehicle;

    @FindBy(xpath = "(//button[@data-test-id='proceed-to-review'])[1]")
    private WebElement continueToReviewBtn;

    @FindBy(xpath = "(//h2[text()='Rental Details'])[1]")
    private WebElement rentalDetailsHeader;

    @FindBy(xpath = "//h2[text()='Contact Details']")
    private WebElement contactDetailsHeader;

    @FindBy(xpath = "//button[@aria-label='Reserve Now']")
    private WebElement reserveBtn;

    @FindBy(xpath = "//div[@class='spinner-container']")
    private WebElement spinner;

    public ReservationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        PageFactory.initElements(driver, this);
    }

    public void selectReservationsTab (){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.reservationPage));
        this.reservationPage.click();
    }

    public void selectCarReservations () {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.carReservationPage));
        this.carReservationPage.click();
    }

    public void enterPickUpLocation (String pickupLocation) {
        this.wait.until(ExpectedConditions.visibilityOf(this.pickUpLocationTxt));
        this.pickUpLocationTxt.sendKeys(pickupLocation);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.airportLocation));
        this.airportLocation.click();
    }

    public void checkAvailability() {
        this.wait.until(ExpectedConditions.visibilityOf(this.checkAvailabilityBtn));
        this.checkAvailabilityBtn.click();
    }

    public void selectVehicle() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.selectVehicle));
        this.selectVehicle.click();
    }

    public void continueToReview() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        this.wait.until(ExpectedConditions.invisibilityOfAllElements(this.spinner));
        this.wait.until(ExpectedConditions.visibilityOf(this.continueToReviewBtn));
        this.wait.until(ExpectedConditions.elementToBeClickable(this.continueToReviewBtn));
        this.continueToReviewBtn.click();
    }

    public void confirmReviewPage() {
        this.wait.until(ExpectedConditions.visibilityOf(this.contactDetailsHeader));
        this.reserveBtn.isEnabled();
        System.out.println(this.rentalDetailsHeader.getText());
    }
}
