package com.epam.aqa.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomWaits {
    public static WebElement waitBeforeChoosingMenuOption(String locator, WebDriver driver, int timeout) {
        WebElement position = new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));

        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.elementToBeClickable(position));

        return position;
    }

    public static WebElement waitBeforeChoosingMenuOption(WebElement webElement, WebDriver driver, int timeout) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
