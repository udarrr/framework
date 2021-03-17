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

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();

                    if (System.getProperty("mode").equals("headless")) {
                        driver = new FirefoxDriver(new FirefoxOptions().addArguments("--headless" , "--window-size=1920,1080"));
                    } else {
                        driver = new FirefoxDriver();
                    }
                    break;
                }
                case "edge": {
                    WebDriverManager.edgedriver().setup();

                    if (System.getProperty("mode").equals("headless")) {
                        driver = new EdgeDriver(new EdgeOptions().addArguments("--headless" , "--window-size=1920,1080"));
                    } else {
                        driver = new EdgeDriver();
                    }
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();

                    if (System.getProperty("mode").equals("headless")) {
                        driver = new ChromeDriver(new ChromeOptions().addArguments("--headless" , "--window-size=1920,1080"));
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