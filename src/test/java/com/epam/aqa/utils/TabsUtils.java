package com.epam.aqa.utils;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class TabsUtils {
    public static ArrayList<String> getCurrentTabs(WebDriver driver) {
        return new ArrayList<>(driver.getWindowHandles());
    }
}
