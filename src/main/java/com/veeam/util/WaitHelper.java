package com.veeam.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.veeam.util.DriverHelper.getDriver;

public class WaitHelper {
    private static final int TIMEOUT;
    private static final WebDriverWait WAIT;

    static {
        TIMEOUT = 10;
        WAIT = new WebDriverWait(getDriver(), Duration.ofSeconds(TIMEOUT));
    }

    public static void toBeClickable(WebElement element) {
        WAIT.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void toBeVisible(WebElement element) {
        WAIT.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean waitForjQueryLoad() {

        // WAIT for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) executeJavaScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };
        return WAIT.until(jQueryLoad);
    }

    public boolean waitForJStoLoad() {

        // WAIT for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return executeJavaScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        return WAIT.until(jsLoad);
    }

    private Object executeJavaScript(String s) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return js.executeScript(s);
    }

}

