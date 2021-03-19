package com.epam.aqa.pages;

import com.epam.aqa.models.ProcessData;
import com.epam.aqa.waits.CustomConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CloudGooglePageWithPricingCalculatorFrame extends AbstractPage {
    @FindBy(css = "#cloud-site > devsite-iframe > iframe")
    private WebElement iFrame;

    @FindBy(css = "#myFrame")
    private WebElement iFrameCalculatorForm;

    public CloudGooglePageWithPricingCalculatorFrame(WebDriver driver, ProcessData processData) {
        super(driver, processData);
    }

    @Override
    protected CloudGooglePageWithPricingCalculatorFrame openPage() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).withMessage("javascript didn't load")
                .until(CustomConditions.jsLoadCompleted());

        logger.info("Opened CloudGooglePageWithPricingCalculatorFrame");

        return this;
    }

    public PricingCalculatorPageFrame moveToCalculatorPageFrame() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(iFrame));

        driver.switchTo().frame(iFrame);
        String linkPricingCalculatorPage = iFrameCalculatorForm.getAttribute("src");

        driver.get(linkPricingCalculatorPage);

        logger.info("Moved to PricingCalculatorPageFrame");

        return new PricingCalculatorPageFrame(driver,processData);
    }
}
