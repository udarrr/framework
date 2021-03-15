package com.epam.aqa.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSingleton {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (null == driver) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    driver.manage().window().setSize(new Dimension(1920, 1080));
                    break;
                }
                case "edge": {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().setSize(new Dimension(1920, 1080));
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    driver.manage().window().setSize(new Dimension(1920, 1080));
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