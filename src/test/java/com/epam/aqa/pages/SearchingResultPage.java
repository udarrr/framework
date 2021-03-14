package com.epam.aqa.pages;

import com.epam.aqa.model.ProgressData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchingResultPage extends AbstractPage {
    @FindBy(xpath = "//a[@class='gs-title']/b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement googleCalculatorLink;

    @Override
    public PricingCalculatorPage openPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(googleCalculatorLink));

        googleCalculatorLink.click();

        return new PricingCalculatorPage(driver, progressData);
    }

    public SearchingResultPage(WebDriver driver, ProgressData progressData) {
        super(driver, progressData);
        this.driver = driver;
        this.progressData = progressData;
        PageFactory.initElements(driver, this);
    }
}