package com.veeam.util;

import org.openqa.selenium.WebElement;

public class MyWebElement {

    private MyWebElement() {
    }

    public static WaitHelper waitHelper = new WaitHelper();

    public static void click(WebElement element) {
        waitHelper.toBeClickable(element);
        waitHelper.toBeVisible(element);
        element.click();
    }

    public static boolean isDisplayed(WebElement element) {
        new WaitHelper().toBeClickable(element);
        WaitHelper.toBeVisible(element);
        return element.isDisplayed();
    }

    public static String getText(WebElement element) {
        new WaitHelper().toBeClickable(element);
        WaitHelper.toBeVisible(element);
        return element.getText();
    }
}

