package com.veeam;

import com.veeam.pages.Vacancies;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.veeam.util.DriverHelper.getDriver;
import static com.veeam.util.DriverHelper.setDriver;

public class BaseTest {
    protected WebDriver driver;
    protected Vacancies vacancies;

    @BeforeMethod
    public void setUp() {
        driver = getDriver();
        vacancies = new Vacancies(driver).get();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            setDriver(null);
        }
    }
}
