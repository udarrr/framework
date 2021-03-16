package com.epam.aqa.pages;

import com.epam.aqa.models.ProgressData;
import com.epam.aqa.waits.CustomConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class TemporaryEmailHomePage extends AbstractPage {
    private String HOME_PAGE_URL = "https://10minutemail.com";

    @FindBy(xpath = "//*[@class='copy_icon']")
    private WebElement iconCopyEmail;

    @FindBy(xpath = "//*[@id='mail_messages_content']//span[text()='Google Cloud Platform Price Estimate']")
    private WebElement containerWithLetter;

    @FindBy(xpath = "//*[@id='mobilepadding']//td[2]/h3")
    private WebElement fieldTotalPriceEstimateBill;

    @FindBy(id = "mail_address")
    private WebElement inputEmailAddress;

    String browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName().toLowerCase();

    @Override
    public TemporaryEmailHomePage openPage() {
        driver.get(HOME_PAGE_URL);

        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .withMessage("javascript didn't load")
                .until(CustomConditions.jsLoadCompleted());

        return this;
    }

    public TemporaryEmailHomePage(WebDriver driver, ProgressData progressData, JavascriptExecutor executor) {
        super(driver, progressData, executor);
        this.driver = driver;
        this.progressData = progressData;
        this.executor = executor;
        PageFactory.initElements(driver, this);
    }

    public TemporaryEmailHomePage copyTemporaryEmail() {
        if (browserName.equals("firefox")) {
            new WebDriverWait(driver,Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(CustomConditions.inputEmailJQueryLoadCompleted());
            String temporaryEmail = (String) executor.executeScript("return document.querySelector('#mail_address').value");
            progressData.setCurrentEmail(temporaryEmail);
        } else {
            iconCopyEmail.click();
        }

        logger.info("Email copied");

        return this;
    }

    public PricingCalculatorPage comeBackToCalculator() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

        return new PricingCalculatorPage(driver, progressData, executor);
    }

    public TemporaryEmailHomePage checkLetterInTemporaryEmailBox() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(containerWithLetter));

        containerWithLetter.click();

        return this;
    }

    public boolean compareCalculatorTotalPriceResultHasTheSamePriceLikeInTemporaryEmailLetter() {
        String priceInEmail = fieldTotalPriceEstimateBill.getText();

        return progressData.getCurrentPriceInCalculator().contains(priceInEmail);
    }
}