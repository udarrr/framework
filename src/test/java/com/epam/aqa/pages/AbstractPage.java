package com.epam.aqa.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final String DESCRIPTION_PRICE_FIELD = "Estimated Component Cost";
    protected String currentPriceInCalculator;

    protected abstract AbstractPage openPage();
    protected final int WAIT_TIMEOUT_SECONDS = 15;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}