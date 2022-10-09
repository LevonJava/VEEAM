package com.veeam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import java.util.List;

import static com.veeam.util.MyWebElement.click;
import static com.veeam.util.MyWebElement.getText;

public class Vacancies extends LoadableComponent<Vacancies> {
    private WebDriver driver;
    private String URL = "https://cz.careers.veeam.com/vacancies";

    public Vacancies(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[class = 'display-1 header-custom-spacer']")
    private WebElement title;
    @FindBy(id = "sl")
    private List<WebElement> all_Department_Language;
    @FindBy(className = "dropdown-item")
    private List<WebElement> researchDevelopment;

    @FindBy(className = "custom-control-label")
    private WebElement english;
    @FindBy(xpath = "//*[text()='Clear filters']")
    private WebElement clearButton;

    @FindBy(css = "[class = 'card-body py-0']")
    private List<WebElement> findedJobs;



    public String getTitleText() {
        return getText(title);
    }

    public void clickOnDepartmentLanguage(int x) {
        click(all_Department_Language.get(x));
    }

    public void chooseResearchDevelopment() {
        click(researchDevelopment.get(3));
    }

    public void chooseEnglish() {
        click(english);
    }

    public void clearFilters(){
        click(clearButton);
    }

    public int countJobs(){
        return findedJobs.size();
    }

    @Override
    protected void load() {
        driver.get(URL);
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(driver.getCurrentUrl().contains(URL), "Vacancies page is not loaded");
    }

}
