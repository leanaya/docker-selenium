package com.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightConfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//font[contains(text(),'Flight')]")
    private WebElement FlightConfirmationHeader;

    @FindBy(xpath ="//font[contains(text(),'$584 USD')]|//font[contains(text(),'$1169 USD')]|//font[contains(text(),'$1753 USD')]|//font[contains(text(),'$2338 USD')]")
    private List<WebElement> prices;

    @FindBy(linkText = "SIGN-OFF")
    private WebElement signOffLink;

    public FlightConfirmationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public String getPrice(){
        this.wait.until(ExpectedConditions.visibilityOf(this.FlightConfirmationHeader));
        System.out.println(this.FlightConfirmationHeader.getText());
        System.out.println(this.prices.get(0).getText());
        String price = this.prices.get(0).getText();
        this.signOffLink.click();
        return price;
    }
}
