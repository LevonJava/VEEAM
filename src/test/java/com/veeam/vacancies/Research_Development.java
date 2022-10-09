package com.veeam.vacancies;

import com.veeam.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Research_Development extends BaseTest {

    @Test(description = "TC-1")
    public void checkWebPage() {
        Assert.assertEquals(vacancies.getTitleText(), "Build your career at Veeam", "Title is incorrect");
    }

    @Test(description = "TC-2")
    public void countVacancies() {
        vacancies.clearFilters();
        vacancies.clickOnDepartmentLanguage(0);
        vacancies.chooseResearchDevelopment();
        vacancies.clickOnDepartmentLanguage(1);
        vacancies.chooseEnglish();
        Assert.assertEquals(vacancies.countJobs(), 11, "Actual amount of finded jobs isn't the same what we expected");
    }
}
