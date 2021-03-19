package com.epam.aqa.pages;

import com.epam.aqa.models.ProcessData;
import com.epam.aqa.utils.JavascriptUtils;
import com.epam.aqa.utils.TabsUtils;
import com.epam.aqa.waits.CustomConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class TemporaryEmailHomePage extends AbstractPage {
    private String HOME_PAGE_URL = "https://10minutemail.com";
    private final int WAIT_EMAIL_TIMEOUT_SECONDS = 30;

    @FindBy(xpath = "//*[@class='copy_icon']")
    private WebElement iconCopyEmail;

    @FindBy(xpath = "//*[@id='mail_messages_content']//span[text()='Google Cloud Platform Price Estimate']")
    private WebElement containerWithLetter;

    @FindBy(xpath = "//*[@id='mobilepadding']//td[2]/h3")
    private WebElement fieldTotalPriceEstimateBill;

    private final String inputIDEmailAddress = "mail_address";

    @Override
    public TemporaryEmailHomePage openPage() {
        driver.get(HOME_PAGE_URL);

        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .withMessage("javascript didn't load")
                .until(CustomConditions.jsLoadCompleted());

        return this;
    }

    public TemporaryEmailHomePage(WebDriver driver, ProcessData processData) {
        super(driver, processData);
    }

    public TemporaryEmailHomePage copyTemporaryEmail() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(CustomConditions.inputEmailJQueryLoadCompleted());

        String temporaryEmail = JavascriptUtils.getValueByLocatorThroughJSExecutor(driver, inputIDEmailAddress);
        processData.setCurrentEmail(temporaryEmail);

        logger.info("Email copied");

        return this;
    }

    public PricingCalculatorPageFrame openPricingCalculatorTab(int tabIndex) {
        driver.switchTo().window(TabsUtils.getCurrentTabs(driver).get(tabIndex));

        return new PricingCalculatorPageFrame(driver, processData);
    }

    public TemporaryEmailHomePage checkLetterInTemporaryEmailBox() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_EMAIL_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(containerWithLetter));

        containerWithLetter.click();

        return this;
    }

    public String totalPriceInTemporaryEmailLetter() {

        return fieldTotalPriceEstimateBill.getText();
    }
}