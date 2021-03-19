package com.epam.aqa.pages;

import com.epam.aqa.models.ProcessData;
import com.epam.aqa.waits.CustomConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CloudGooglePageWithSearchingResultFrame extends AbstractPage {
    private String partOfSearchQuery = "//a[@class='gs-title']/b[text()='%s']";

    public CloudGooglePageWithSearchingResultFrame(WebDriver driver, ProcessData processData) {
        super(driver, processData);
    }

    @Override
    public CloudGooglePageWithSearchingResultFrame openPage() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).withMessage("javascript didn't load")
                .until(CustomConditions.jsLoadCompleted());

        logger.info("Opened page CloudGooglePageWithSearchingResultFrame");

        return this;
    }

    public CloudGooglePageWithPricingCalculatorFrame chooseLinkDependingSearchingQuery() {
        String locator = String.format(partOfSearchQuery, processData.getCurrentSearchQuery());

        WebElement googleCalculatorLink = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));

        googleCalculatorLink.click();

        logger.info("Chose link depending searching query");

        return new CloudGooglePageWithPricingCalculatorFrame(driver, processData);
    }
}