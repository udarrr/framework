package com.epam.aqa.pages;

import com.epam.aqa.models.ProgressData;
import com.epam.aqa.waits.CustomConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class TemporaryEmailHomePage extends AbstractPage {
    private String HOME_PAGE_URL = "https://10minutemail.com";

    @FindBy(id = "copy_address")
    private WebElement iconCopyEmail;

    @FindBy(xpath = "//*[@id='mail_messages_content']//span[text()='Google Cloud Platform Price Estimate']")
    private WebElement containerWithLetter;

    @FindBy(xpath = "//*[@id='mobilepadding']//td[2]/h3")
    private WebElement fieldTotalPriceEstimateBill;

    @Override
    public TemporaryEmailHomePage openPage() {
        driver.get(HOME_PAGE_URL);

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).withMessage("javascript didn't load")
                .until(CustomConditions.jQueryAJAXsCompleted());

        return this;
    }

    public TemporaryEmailHomePage(WebDriver driver, ProgressData progressData) {
        super(driver, progressData);
        this.driver = driver;
        this.progressData = progressData;
        PageFactory.initElements(driver, this);
    }

    public TemporaryEmailHomePage copyTemporaryEmail() {
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(iconCopyEmail));
        iconCopyEmail.click();

        logger.info("Email copied");

        return this;
    }

    public PricingCalculatorPage comeBackToCalculator() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

        return new PricingCalculatorPage(driver, progressData);
    }

    public TemporaryEmailHomePage checkLetterInTemporaryEmailBox() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(containerWithLetter));

        containerWithLetter.click();

        return this;
    }

    public boolean compareCalculatorTotalPriceResultHasTheSamePriceLikeInTemporaryEmailLetter() {
        String priceInEmail = fieldTotalPriceEstimateBill.getText();

        return progressData.getCurrentPriceInCalculator().contains(priceInEmail);
    }
}