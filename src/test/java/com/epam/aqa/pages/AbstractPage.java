package com.epam.aqa.pages;

import com.epam.aqa.models.ProgressData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final String DESCRIPTION_PRICE_FIELD = "Estimated Component Cost";
    protected ProgressData progressData;
    protected final Logger logger = LogManager.getRootLogger();
    protected JavascriptExecutor executor;

    protected abstract AbstractPage openPage();

    protected final int WAIT_TIMEOUT_SECONDS = 25;

    protected AbstractPage(WebDriver driver, ProgressData progressData, JavascriptExecutor executor) {
        this.driver = driver;
        this.progressData = progressData;
        this.executor = executor;
    }
}