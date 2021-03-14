package com.epam.aqa.pages;

import com.epam.aqa.model.ProgressData;
import com.epam.aqa.waits.CustomConditions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleHomePage extends AbstractPage {
    private static final String HOME_PAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//div[@class='devsite-searchbox']/input")
    private WebElement searchInput;

    public CloudGoogleHomePage(WebDriver driver, ProgressData progressData) {
        super(driver, progressData);
        this.driver = driver;
        this.progressData = progressData;
        PageFactory.initElements(driver, this);
    }

    public CloudGoogleHomePage openPage() {
        driver.get(HOME_PAGE_URL);

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).withMessage("javascript didn't load")
                .until(CustomConditions.jsLoadCompleted());

        logger.info("Opened page https://cloud.google.com/");

        return this;
    }

    public SearchingResultPage fillSearchInput() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(searchInput));

        searchInput.click();
        searchInput.sendKeys("Google Cloud Platform Pricing Calculator");
        searchInput.sendKeys(Keys.ENTER);

        return new SearchingResultPage(driver, progressData);
    }
}