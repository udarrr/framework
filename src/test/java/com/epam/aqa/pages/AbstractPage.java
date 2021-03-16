package com.epam.aqa.pages;

import com.epam.aqa.models.ProcessData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected ProcessData processData;
    protected final Logger logger = LogManager.getRootLogger();
    protected JavascriptExecutor executor;

    protected abstract AbstractPage openPage();

    protected final int WAIT_TIMEOUT_SECONDS = 25;
    protected final int TIMEOUT_SLEEP = 5;

    protected AbstractPage(WebDriver driver, ProcessData processData, JavascriptExecutor executor) {
        this.driver = driver;
        this.processData = processData;
        this.executor = executor;
    }
}