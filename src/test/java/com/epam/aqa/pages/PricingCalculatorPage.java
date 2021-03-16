package com.epam.aqa.pages;

import com.epam.aqa.models.EstimateResult;
import com.epam.aqa.models.ProcessData;
import com.epam.aqa.waits.CustomConditions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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

    @FindBy(xpath = "//md-list[@class='cartitem ng-scope']/md-list-item/div")
    private List<WebElement> createdEstimate;

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement buttonEmailEstimate;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement buttonSendEmail;

    String partOfLocatorPositionMenuTypeOperationSystem = "//md-option[@value='%s']";
    String partOfLocatorForPositionDropDownList = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='%s']";

    private final String DESCRIPTION_PRICE_FIELD = "Estimated Component Cost";

    public PricingCalculatorPage(WebDriver driver, ProcessData processData, JavascriptExecutor executor) {
        super(driver, processData, executor);
        this.driver = driver;
        this.processData = processData;
        this.executor = executor;
        PageFactory.initElements(driver, this);
    }

    @Override
    protected PricingCalculatorPage openPage() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).withMessage("javascript didn't load")
                .until(CustomConditions.jsLoadCompleted());

        logger.info("Opened PricingCalculatorPage ");

        return this;
    }

    public WebElement buildFullLocatorForPositionMenu(String condition) {
        String fullLocator = String.format(partOfLocatorForPositionDropDownList, condition);

        return waitBeforeChoosingMenuOption(fullLocator);
    }

    private WebElement waitBeforeChoosingMenuOption(String locator) {
        WebElement position = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));

        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(position));

        return position;
    }

    private WebElement waitBeforeChoosingMenuOption(WebElement webElement) {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public PricingCalculatorPage chooseComputerEngine() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(iFrame));

        driver.switchTo().frame(iFrame);
        driver.switchTo().frame(iFrameCalculatorAfterIFrame);

        tabComputerEngine.click();

        return this;
    }

    public PricingCalculatorPage fillInputNumberInstances(String number) {
        inputNumberInstances.click();
        inputNumberInstances.sendKeys(number);

        logger.info("Entered instances " + number);

        return this;
    }

    private void clickDependOnBrowser(WebElement webElement) {
        if (processData.getCurrentBrowser().equals("firefox")) {
            executor.executeScript("arguments[0].click();", webElement);
        } else {
            webElement.click();
        }
    }

    public PricingCalculatorPage chooseOperationSystem(String condition) {
        clickDependOnBrowser(inputContainerTypeOperationSystem);

        String fullLocator = String.format(partOfLocatorPositionMenuTypeOperationSystem, condition);

        WebElement position = waitBeforeChoosingMenuOption(fullLocator);
        clickDependOnBrowser(position);

        logger.info("Chose operation system " + condition);

        return this;
    }

    public PricingCalculatorPage chooseMachineClass(String machineClass) {
        clickDependOnBrowser(inputContainerMachineClass);

        WebElement position = buildFullLocatorForPositionMenu(machineClass);
        clickDependOnBrowser(position);

        logger.info("Chose machine class " + machineClass);

        return this;
    }

    public PricingCalculatorPage chooseSeries(String series) {
        clickDependOnBrowser(inputContainerSeries);

        WebElement position = buildFullLocatorForPositionMenu(series);
        clickDependOnBrowser(position);

        logger.info("Chose series class " + series);

        return this;
    }

    public PricingCalculatorPage chooseMachineType(String type) {
        clickDependOnBrowser(inputContainerMachineType);

        WebElement position = buildFullLocatorForPositionMenu(type);
        clickDependOnBrowser(position);

        logger.info("Chose machine type " + type);

        return this;
    }

    public PricingCalculatorPage addGPUs(String number, String type) {
        clickDependOnBrowser(checkBoxAddGPU);

        waitBeforeChoosingMenuOption(inputContainerGPUNumber);
        clickDependOnBrowser(inputContainerGPUNumber);

        WebElement positionNumber = buildFullLocatorForPositionMenu(number);
        clickDependOnBrowser(positionNumber);

        waitBeforeChoosingMenuOption(inputContainerGPUType);
        clickDependOnBrowser(inputContainerGPUType);

        WebElement positionType = buildFullLocatorForPositionMenu(type);
        clickDependOnBrowser(positionType);

        logger.info("Add gpu " + number + "and" + type);

        return this;
    }

    public PricingCalculatorPage chooseLocalSSD(String count) {
        waitBeforeChoosingMenuOption(inputContainerLocalSSD);
        clickDependOnBrowser(inputContainerLocalSSD);

        WebElement position = buildFullLocatorForPositionMenu(count);
        clickDependOnBrowser(position);

        logger.info("Chose local SSD count " + count);

        return this;
    }

    public PricingCalculatorPage chooseDataCenterLocation(String location) {
        clickDependOnBrowser(inputContainerDataCenterLocation);

        WebElement position = buildFullLocatorForPositionMenu(location);
        clickDependOnBrowser(position);

        logger.info("Chose datacenter location " + location);

        return this;
    }

    public PricingCalculatorPage chooseCommittedUsage(String period) {
        clickDependOnBrowser(inputContainerCommittedUsage);

        WebElement position = buildFullLocatorForPositionMenu(period);
        clickDependOnBrowser(position);

        logger.info("Chose committed usage " + period);

        return this;
    }

    public PricingCalculatorPage pressButtonAddToEstimate() {
        clickDependOnBrowser(buttonAddToEstimate);

        logger.info("Pressed button add estimate");

        return this;
    }

    public PricingCalculatorPage saveCalculatorTotalPriceResult() {
        for (WebElement price : createdEstimate) {
            if (price.getText().contains(DESCRIPTION_PRICE_FIELD)) {
                processData.setCurrentPriceInCalculator(price.getText());
            }
        }
        return this;
    }

    public PricingCalculatorPage pressButtonEmailEstimate() {
        buttonEmailEstimate.click();

        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(inputEmail));

        logger.info("ComputerEngine form filled");

        return this;
    }

    public TemporaryEmailHomePage openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        return new TemporaryEmailHomePage(driver, processData, executor);
    }

    public PricingCalculatorPage enterEmail() {
        driver.switchTo().frame(iFrame);
        driver.switchTo().frame(iFrameCalculatorAfterIFrame);

        if (processData.getCurrentBrowser().equals("firefox")) {
            inputEmail.sendKeys(processData.getCurrentEmail());
        } else {
            inputEmail.sendKeys(Keys.LEFT_CONTROL, "v");
        }

        logger.info("Email wrote down");

        return this;
    }

    public PricingCalculatorPage pressButtonSendEmail() {
        clickDependOnBrowser(buttonSendEmail);

        logger.info("Email sent");

        return this;
    }

    public TemporaryEmailHomePage switchTabToTemporaryEmailHomePage() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        return new TemporaryEmailHomePage(driver, processData, executor);
    }

    public boolean checkFieldsCreatedEstimateHasTheSameDataLikeInCalculator(String field1, String field2, String field3, String field4, String field5) {
        List<String> fields = new ArrayList<>(Arrays.asList(field1, field2, field3, field4, field5));

        return getResultComparingFieldsWithCommonData(fields);
    }


    public boolean checkPriceCreatedEstimateHasTheSameValueLikeInManualTest(String manualTestValue) {
        return createdEstimate.stream().filter(t -> t.getText()
                .contains(DESCRIPTION_PRICE_FIELD))
                .anyMatch(m -> m.getText().contains(manualTestValue));
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