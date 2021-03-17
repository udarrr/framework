package com.epam.aqa.pages;

import com.epam.aqa.models.ProcessData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected ProcessData processData;
    protected final Logger logger = LogManager.getRootLogger();

    protected abstract AbstractPage openPage();

    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPage(WebDriver driver, ProcessData processData) {
        this.driver = driver;
        this.processData = processData;
        PageFactory.initElements(driver, this);
    }
}