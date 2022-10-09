package com.veeam.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverHelper {
    private static WebDriver driver = null;
    private static ChromeOptions options;

    private DriverHelper() {

    }

    public static void setDriver(WebDriver driver) {
        DriverHelper.driver = driver;
    }

    private static ChromeOptions setOptions() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        return options;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver(setOptions());
        }
        return driver;
    }

}
