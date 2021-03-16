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
                        .executeScript("return (document.readyState == 'complete' && jQuery.active == 0 && window.jQuery != null)");
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

    public static ExpectedCondition<Boolean> inputEmailJQueryLoadCompleted() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return (Boolean) ((JavascriptExecutor) webDriver)
                        .executeScript("return document.querySelector('#mail_address').value.length != 0");
            }
        };
    }
}