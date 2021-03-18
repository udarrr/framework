package com.epam.aqa.utils;

import com.epam.aqa.models.ProcessData;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class JavascriptUtils {
    public static ArrayList<String> openTab(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        return tabs;
    }

    public static ArrayList<String> getCurrentTabs(WebDriver driver) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        return tabs;
    }

    public static void clickDependingBrowser(WebElement webElement, String browser, WebDriver driver) {
        if (browser.equals("firefox")) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
        } else {
            webElement.click();
        }
    }
}
