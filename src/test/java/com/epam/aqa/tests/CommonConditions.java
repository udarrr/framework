package com.epam.aqa.tests;

import com.epam.aqa.drivers.DriverSingleton;
import com.epam.aqa.models.ProcessData;
import com.epam.aqa.utils.TestListener;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;
    protected JavascriptExecutor executor;
    ProcessData processData;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = DriverSingleton.getDriver();
        executor = (JavascriptExecutor) driver;
        processData = new ProcessData();
        processData.setCurrentBrowser(((RemoteWebDriver) driver).getCapabilities().getBrowserName().toLowerCase());
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}