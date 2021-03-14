package com.epam.aqa.pages;

import com.epam.aqa.models.EstimateResult;
import com.epam.aqa.models.ProgressData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PricingCalculatorPage extends AbstractPage {
    @FindBy(xpath = "//a[@class='gs-title']/b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement googleCalculatorLink;

    @FindBy(css = "#cloud-site > devsite-iframe > iframe")
    private WebElement iFrame;

    @FindBy(css = "#myFrame")
    private WebElement iFrameCalculatorAfterIFrame;

    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine' and @class='tab-holder compute']")
    private WebElement tabComputerEngine;

    @FindBy(id = "input_65")
    private WebElement inputNumberInstances;

    @FindBy(id = "select_value_label_58")
    private WebElement inputContainerTypeOperationSystem;

    String partOfLocatorPositionMenuTypeOperationSystem = "//md-option[@value='%s']";

    @FindBy(id = "select_82")
    private WebElement inputContainerMachineClass;

    @FindBy(id = "select_90")
    private WebElement inputContainerSeries;

    @FindBy(id = "select_92")
    private WebElement inputContainerMachineType;

    @FindBy(xpath = "//h2[contains(text(),'Instances')]/..//md-checkbox[@aria-label='Add GPUs']")
    private WebElement checkBoxAddGPU;

    @FindBy(xpath = "//h2[contains(text(),'Instances')]/..//md-select[@placeholder='Number of GPUs']")
    private WebElement inputContainerGPUNumber;

    @FindBy(xpath = "//h2[contains(text(),'Instances')]/..//md-select[@placeholder='GPU type']")
    private WebElement inputContainerGPUType;

    @FindBy(id = "select_357")
    private WebElement inputContainerLocalSSD;

    @FindBy(id = "select_94")
    private WebElement inputContainerDataCenterLocation;

    @FindBy(id = "select_101")
    private WebElement inputContainerCommittedUsage;

    @FindBy(xpath = "//h2[contains(text(),'Instances')]/..//button[@aria-label='Add to Estimate']")
    private WebElement buttonAddToEstimate;

    String partOfLocatorForPositionDropDownList = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='%s']";

    @FindBy(xpath = "//md-list[@class='cartitem ng-scope']/md-list-item/div")
    private List<WebElement> createdEstimate;

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement buttonEmailEstimate;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement buttonSendEmail;

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public PricingCalculatorPage(WebDriver driver, ProgressData progressData) {
        super(driver, progressData);
        this.driver = driver;
        this.progressData = progressData;
        PageFactory.initElements(driver, this);
    }

    public WebElement buildFullLocatorForPositionMenu(String condition) {
        String fullLocator = String.format(partOfLocatorForPositionDropDownList, condition);

        return waitBeforeChoosingMenuOption(fullLocator);
    }

    private WebElement waitBeforeChoosingMenuOption(String locator) {
        WebElement position = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(position));

        return position;
    }

    public PricingCalculatorPage chooseComputerEngine() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(iFrame));

        driver.switchTo().frame(iFrame);
        driver.switchTo().frame(iFrameCalculatorAfterIFrame);
        tabComputerEngine.click();

        logger.info("ComputerEngine form available");

        return this;
    }

    public PricingCalculatorPage fillInputNumberInstances(String number) {
        inputNumberInstances.click();
        inputNumberInstances.sendKeys(number);

        return this;
    }

    public PricingCalculatorPage chooseOperationSystem(String condition) {
        inputContainerTypeOperationSystem.click();

        String fullLocator = String.format(partOfLocatorPositionMenuTypeOperationSystem, condition);

        WebElement position = waitBeforeChoosingMenuOption(fullLocator);
        position.click();

        return this;
    }

    public PricingCalculatorPage chooseMachineClass(String machineClass) {
        inputContainerMachineClass.click();

        WebElement position = buildFullLocatorForPositionMenu(machineClass);
        position.click();

        return this;
    }

    public PricingCalculatorPage chooseSeries(String series) {
        inputContainerSeries.click();

        WebElement position = buildFullLocatorForPositionMenu(series);
        position.click();

        return this;
    }

    public PricingCalculatorPage chooseMachineType(String type) {
        inputContainerMachineType.click();

        WebElement position = buildFullLocatorForPositionMenu(type);
        position.click();

        return this;
    }

    public PricingCalculatorPage addGPUs(String number, String type) {
        checkBoxAddGPU.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(inputContainerGPUNumber));

        inputContainerGPUNumber.sendKeys(Keys.RETURN);

        WebElement positionNumber = buildFullLocatorForPositionMenu(number);
        positionNumber.click();

        inputContainerGPUType.sendKeys(Keys.RETURN);


        WebElement positionType = buildFullLocatorForPositionMenu(type);
        positionType.click();

        return this;
    }

    public PricingCalculatorPage chooseLocalSSD(String count) {
        inputContainerLocalSSD.sendKeys(Keys.RETURN);

        WebElement position = buildFullLocatorForPositionMenu(count);
        position.click();

        return this;
    }

    public PricingCalculatorPage chooseDataCenterLocation(String location) {
        inputContainerDataCenterLocation.sendKeys(Keys.RETURN);

        WebElement position = buildFullLocatorForPositionMenu(location);
        position.click();

        return this;
    }

    public PricingCalculatorPage chooseCommittedUsage(String period) {
        inputContainerCommittedUsage.sendKeys(Keys.RETURN);

        WebElement position = buildFullLocatorForPositionMenu(period);
        position.click();

        return this;
    }

    public PricingCalculatorPage pressButtonAddToEstimate() {
        buttonAddToEstimate.click();

        return this;
    }

    public PricingCalculatorPage saveCalculatorTotalPriceResult() {
        for (WebElement price : createdEstimate) {
            if (price.getText().contains(DESCRIPTION_PRICE_FIELD)) {
                progressData.setCurrentPriceInCalculator(price.getText());
            }
        }
        return this;
    }

    public PricingCalculatorPage pressButtonEmailEstimate() {
        buttonEmailEstimate.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(inputEmail));

        logger.info("ComputerEngine form filled");

        return this;
    }

    public TemporaryEmailHomePage openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        return new TemporaryEmailHomePage(driver, progressData);
    }

    public PricingCalculatorPage enterEmail() {
        driver.switchTo().frame(iFrame);
        driver.switchTo().frame(iFrameCalculatorAfterIFrame);
        inputEmail.sendKeys(Keys.LEFT_CONTROL, "v");

        logger.info("Email wrote down");

        return this;
    }

    public PricingCalculatorPage pressButtonSendEmail() {
        buttonSendEmail.click();

        logger.info("Email sent");

        return this;
    }

    public TemporaryEmailHomePage switchTabToTemporaryEmailHomePage() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        return new TemporaryEmailHomePage(driver, progressData);
    }

    public boolean checkFieldsCreatedEstimateHasTheSameDataLikeInCalculator(String field1, String field2, String field3, String field4, String field5) {
        List<String> fields = new ArrayList<>(Arrays.asList(field1, field2, field3, field4, field5));
        return getResultComparingFieldsWithCommonData(fields);
    }


    public boolean checkPriceCreatedEstimateHasTheSameValueLikeInManualTest(String manualTestValue) {
        return createdEstimate.stream().filter(x -> x.getText()
                .contains(DESCRIPTION_PRICE_FIELD))
                .anyMatch(z -> z.getText().contains(manualTestValue));
    }

    private boolean getResultComparingFieldsWithCommonData(List<String> fields) {
        List<String> lines = new ArrayList<>();
        createdEstimate.forEach(x -> lines.add(x.getText()));

        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < fields.size(); j++) {
                if (lines.get(i).contains(fields.get(j))) {
                    if (!findResultInFields(lines.get(i), fields.get(j))) {
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }

    private boolean findResultInFields(String line, String field) {
        EstimateResult estimateResult = new EstimateResult();

        switch (field) {
            case "VM class":
                return line.toLowerCase().endsWith(estimateResult.getVmClassField().toLowerCase());
            case "Instance type":
                return line.toLowerCase().endsWith(estimateResult.getInstanceTypeField().toLowerCase());
            case "Region":
                return line.toLowerCase().endsWith(estimateResult.getRegionField().toLowerCase());
            case "local SSD":
                return line.toLowerCase().endsWith(estimateResult.getLocalSSDField().toLowerCase());
            case "Commitment term":
                return line.toLowerCase().endsWith(estimateResult.getCommitmentTermField().toLowerCase());
            default:
                return false;
        }
    }
}