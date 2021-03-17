package com.epam.aqa.pages;

import com.epam.aqa.models.ProcessData;
import com.epam.aqa.waits.CustomConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CloudGoogleHomePage extends AbstractPage {
    private static final String HOME_PAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//div[@class='devsite-searchbox']/input")
    private WebElement searchInput;

    public CloudGoogleHomePage(WebDriver driver, ProcessData processData, JavascriptExecutor executor) {
        super(driver, processData, executor);
        this.driver = driver;
        this.processData = processData;
        this.executor = executor;
        PageFactory.initElements(driver, this);
    }

    public CloudGoogleHomePage openPage() {
        driver.get(HOME_PAGE_URL);

        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).withMessage("javascript didn't load")
                .until(CustomConditions.jsLoadCompleted());

        logger.info("Opened page " + HOME_PAGE_URL);

        return this;
    }

    public SearchingResultPage fillSearchInput(String query) {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(searchInput));

        searchInput.click();
        searchInput.sendKeys(query);
        searchInput.sendKeys(Keys.ENTER);

        processData.setCurrentSearchQuery(query);

        logger.info("Looking for " + query);

        return new SearchingResultPage(driver, processData, executor);
    }
}