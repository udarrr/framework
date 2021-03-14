package com.epam.aqa.waits;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomConditions {
    public static ExpectedCondition<Boolean> jQueryAJAXsCompleted() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return (Boolean) ((JavascriptExecutor) webDriver)
                        .executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        };
    }

    public static ExpectedCondition<Boolean> jsLoadCompleted() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return (Boolean) ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").toString().equals("complete");
            }
        };
    }
}