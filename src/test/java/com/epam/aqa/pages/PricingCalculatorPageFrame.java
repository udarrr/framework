package com.epam.aqa.pages;

import com.epam.aqa.models.EstimateResult;
import com.epam.aqa.models.ProcessData;
import com.epam.aqa.utils.JavascriptUtils;
import com.epam.aqa.waits.CustomConditions;
import com.epam.aqa.waits.CustomWaits;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PricingCalculatorPageFrame extends AbstractPage {
    private static final String HOME_PAGE_URL = "https://cloudpricingcalculator.appspot.com";

    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine' and @class='tab-holder compute']")
    private WebElement computerEngineForm;

    @FindBy(id = "input_65")
    private WebElement inputNumberInstances;

    @FindBy(id = "select_value_label_58")
    private WebElement inputContainerTypeOperationSystem;

    @FindBy(id = "select_82")
    private WebElement inputContainerMachineClass;

    @FindBy(id = "select_90")
    private WebElement inputContainerSeries;

    @FindBy(id = "select_92")
    private WebElement inputContainerMachineType;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement checkBoxAddGPU;

    private static final String locatorDefineInstanceForm = "//h2[contains(text(),'Instances')]/..";

    @FindBy(xpath = locatorDefineInstanceForm + "//md-select[@placeholder='Number of GPUs']")
    private WebElement inputContainerGPUNumber;

    @FindBy(xpath = locatorDefineInstanceForm + "//md-select[@placeholder='GPU type']")
    private WebElement inputContainerGPUType;

    @FindBy(id = "select_357")
    private WebElement inputContainerLocalSSD;

    @FindBy(id = "select_94")
    private WebElement inputContainerDataCenterLocation;

    @FindBy(id = "select_101")
    private WebElement inputContainerCommittedUsage;

    @FindBy(xpath = locatorDefineInstanceForm + "//button[@aria-label='Add to Estimate']")
    private WebElement buttonAddToEstimate;

    @FindBy(xpath = "//md-list[@class='cartitem ng-scope']/md-list-item/div")
    private List<WebElement> createdEstimate;

    @FindBy(xpath = "//h2[@class='md-title']/b")
    private WebElement totalEstimatedCost;

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement buttonEmailEstimate;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement buttonSendEmail;

    String partOfLocatorForPositionDropDownList = "//div[contains(@class,'md-active md-clickable')]//md-option[@value='%s']";

    public PricingCalculatorPageFrame(WebDriver driver, ProcessData processData) {
        super(driver, processData);
    }

    @Override
    protected PricingCalculatorPageFrame openPage() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).withMessage("javascript didn't load")
                .until(CustomConditions.jsLoadCompleted());

        logger.info("Opened PricingCalculatorPage ");

        return this;
    }

    public PricingCalculatorPageFrame chooseComputerEngineForm() {
        computerEngineForm.click();

        return this;
    }

    public PricingCalculatorPageFrame fillInputNumberInstances(String number) {
        inputNumberInstances.click();
        inputNumberInstances.sendKeys(number);

        logger.info("Entered instances " + number);

        return this;
    }

    public WebElement buildFullLocatorForPositionMenu(String condition) {
        String fullLocator = String.format(partOfLocatorForPositionDropDownList, condition);

        return CustomWaits.waitBeforeChoosingMenuOption(fullLocator, driver, WAIT_TIMEOUT_SECONDS);
    }


    public PricingCalculatorPageFrame chooseOperationSystem(String condition) {
        JavascriptUtils.clickDependingBrowser(inputContainerTypeOperationSystem, processData.getCurrentBrowser(), driver);

        String fullLocator = String.format(partOfLocatorForPositionDropDownList, condition);

        WebElement position = CustomWaits.waitBeforeChoosingMenuOption(fullLocator, driver, WAIT_TIMEOUT_SECONDS);
        JavascriptUtils.clickDependingBrowser(position, processData.getCurrentBrowser(), driver);

        logger.info("Chose operation system " + condition);

        return this;
    }

    public PricingCalculatorPageFrame chooseMachineClass(String machineClass) {
        JavascriptUtils.clickDependingBrowser(inputContainerMachineClass, processData.getCurrentBrowser(), driver);

        WebElement position = buildFullLocatorForPositionMenu(machineClass);
        JavascriptUtils.clickDependingBrowser(position, processData.getCurrentBrowser(), driver);

        logger.info("Chose machine class " + machineClass);

        return this;
    }

    public PricingCalculatorPageFrame chooseSeries(String series) {
        JavascriptUtils.clickDependingBrowser(inputContainerSeries, processData.getCurrentBrowser(), driver);

        WebElement position = buildFullLocatorForPositionMenu(series);
        JavascriptUtils.clickDependingBrowser(position, processData.getCurrentBrowser(), driver);

        logger.info("Chose series class " + series);

        return this;
    }

    public PricingCalculatorPageFrame chooseMachineType(String type) {
        JavascriptUtils.clickDependingBrowser(inputContainerMachineType, processData.getCurrentBrowser(), driver);

        WebElement position = buildFullLocatorForPositionMenu(type);
        JavascriptUtils.clickDependingBrowser(position, processData.getCurrentBrowser(), driver);

        logger.info("Chose machine type " + type);

        return this;
    }

    public PricingCalculatorPageFrame addGPUs(String number, String type) {
        JavascriptUtils.clickDependingBrowser(checkBoxAddGPU, processData.getCurrentBrowser(), driver);

        CustomWaits.waitBeforeChoosingMenuOption(inputContainerGPUNumber, driver, WAIT_TIMEOUT_SECONDS);
        JavascriptUtils.clickDependingBrowser(inputContainerGPUNumber, processData.getCurrentBrowser(), driver);

        WebElement positionNumber = buildFullLocatorForPositionMenu(number);
        JavascriptUtils.clickDependingBrowser(positionNumber, processData.getCurrentBrowser(), driver);

        CustomWaits.waitBeforeChoosingMenuOption(inputContainerGPUType, driver, WAIT_TIMEOUT_SECONDS);
        JavascriptUtils.clickDependingBrowser(inputContainerGPUType, processData.getCurrentBrowser(), driver);

        WebElement positionType = buildFullLocatorForPositionMenu(type);
        JavascriptUtils.clickDependingBrowser(positionType, processData.getCurrentBrowser(), driver);

        logger.info("Add gpu " + number + "and" + type);

        return this;
    }

    public PricingCalculatorPageFrame chooseLocalSSD(String count) {
        CustomWaits.waitBeforeChoosingMenuOption(inputContainerLocalSSD, driver, WAIT_TIMEOUT_SECONDS);
        JavascriptUtils.clickDependingBrowser(inputContainerLocalSSD, processData.getCurrentBrowser(), driver);

        WebElement position = buildFullLocatorForPositionMenu(count);
        JavascriptUtils.clickDependingBrowser(position, processData.getCurrentBrowser(), driver);

        logger.info("Chose local SSD count " + count);

        return this;
    }

    public PricingCalculatorPageFrame chooseDataCenterLocation(String location) {
        JavascriptUtils.clickDependingBrowser(inputContainerDataCenterLocation, processData.getCurrentBrowser(), driver);

        WebElement position = buildFullLocatorForPositionMenu(location);
        JavascriptUtils.clickDependingBrowser(position, processData.getCurrentBrowser(), driver);

        logger.info("Chose datacenter location " + location);

        return this;
    }

    public PricingCalculatorPageFrame chooseCommittedUsage(String period) {
        JavascriptUtils.clickDependingBrowser(inputContainerCommittedUsage, processData.getCurrentBrowser(), driver);

        WebElement position = buildFullLocatorForPositionMenu(period);
        JavascriptUtils.clickDependingBrowser(position, processData.getCurrentBrowser(), driver);

        logger.info("Chose committed usage " + period);

        return this;
    }

    public PricingCalculatorPageFrame pressButtonAddToEstimate() {
        JavascriptUtils.clickDependingBrowser(buttonAddToEstimate, processData.getCurrentBrowser(), driver);

        logger.info("Pressed button add estimate");

        return this;
    }

    public PricingCalculatorPageFrame saveCalculatorTotalPriceResult() {
        processData.setCurrentPriceInCalculator(totalEstimatedCost.getText());

        return this;
    }

    public PricingCalculatorPageFrame pressButtonEmailEstimate() {
        buttonEmailEstimate.click();

        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(inputEmail));

        logger.info("ComputerEngine form filled");

        return this;
    }

    public TemporaryEmailHomePage openNewTab() {
        driver.switchTo().window(JavascriptUtils.openTab(driver).get(1));

        return new TemporaryEmailHomePage(driver, processData);
    }

    public PricingCalculatorPageFrame enterEmail() {
        inputEmail.sendKeys(processData.getCurrentEmail());

        logger.info("Email wrote down");

        return this;
    }

    public PricingCalculatorPageFrame pressButtonSendEmail() {
        JavascriptUtils.clickDependingBrowser(buttonSendEmail, processData.getCurrentBrowser(), driver);

        logger.info("Email sent");

        return this;
    }

    public TemporaryEmailHomePage switchTabToTemporaryEmailHomePage() {
        driver.switchTo().window(JavascriptUtils.getCurrentTabs(driver).get(1));

        return new TemporaryEmailHomePage(driver, processData);
    }

    public boolean checkFieldsCreatedEstimateHasTheSameDataLikeInCalculator(String field1, String field2, String field3, String field4, String field5) {
        List<String> fields = new ArrayList<>(Arrays.asList(field1, field2, field3, field4, field5));

        return getResultComparingFieldsWithCommonData(fields);
    }


    public boolean checkPriceCreatedEstimateHasTheSameValueLikeInManualTest(String manualTestValue) {
        return totalEstimatedCost.getText().contains(manualTestValue);
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