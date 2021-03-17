package com.epam.aqa.pages;

import com.epam.aqa.models.ProcessData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchingResultPage extends AbstractPage {
    private String partOfSearchQuery = "//a[@class='gs-title']/b[text()='%s']";

    public SearchingResultPage(WebDriver driver, ProcessData processData, JavascriptExecutor executor) {
        super(driver, processData, executor);
        this.driver = driver;
        this.processData = processData;
        this.executor = executor;
        PageFactory.initElements(driver, this);
    }

    @Override
    public PricingCalculatorPage openPage() {
        String locator = String.format(partOfSearchQuery,processData.getCurrentSearchQuery());
        WebElement googleCalculatorLink = driver.findElement(By.xpath(locator));

        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(googleCalculatorLink));

        googleCalculatorLink.click();

        return new PricingCalculatorPage(driver, processData, executor);
    }
}