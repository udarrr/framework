package com.epam.aqa.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSingleton {
    private static WebDriver driver;
    private static final String HEADLESS_ARGUMENT = "--headless";
    private static final String RESOLUTION_ARGUMENT = "--window-size=1920,1080";

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();

                    if (System.getProperty("mode").equals("headless")) {
                        driver = new FirefoxDriver(new FirefoxOptions().addArguments(HEADLESS_ARGUMENT,RESOLUTION_ARGUMENT));
                    } else {
                        driver = new FirefoxDriver();
                    }
                    break;
                }
                case "edge": {
                    WebDriverManager.edgedriver().setup();

                    if (System.getProperty("mode").equals("headless")) {
                        driver = new EdgeDriver(new EdgeOptions().addArguments(HEADLESS_ARGUMENT,RESOLUTION_ARGUMENT));
                    } else {
                        driver = new EdgeDriver();
                    }
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();

                    if (System.getProperty("mode").equals("headless")) {
                        driver = new ChromeDriver(new ChromeOptions().addArguments(HEADLESS_ARGUMENT,RESOLUTION_ARGUMENT));
                    } else {
                        driver = new ChromeDriver();
                    }
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}