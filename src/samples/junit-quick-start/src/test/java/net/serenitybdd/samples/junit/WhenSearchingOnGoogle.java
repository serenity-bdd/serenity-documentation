package net.serenitybdd.samples.junit;

import net.serenitybdd.samples.junit.pages.GooglePage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

// tag::header[]
@RunWith(SerenityRunner.class)
public class WhenSearchingOnGoogle {

    @Managed                                                                //<1>
    WebDriver driver;
// end::header[]
// tag::pageObjects[]

    GooglePage googlePage;

// end::pageObjects[]
// tag::simpletest[]
    @Test
    public void shouldInstantiatedDriver() {
        driver.get("http://www.google.com");                                //<3>

        driver.findElement(By.name("q")).sendKeys("firefly");

        new WebDriverWait(driver,5).until(titleContains("Google Search"));

        assertThat(driver.getTitle()).isEqualTo("firefly - Google Search");
    }
// end::simpletest[]
// tag::pageObjectTest[]

    @Test
    public void shouldInstantiatedPageObjects() {

        googlePage.open();

        googlePage.searchFor("firefly");

        assertThat(googlePage.getTitle()).isEqualTo("firefly - Google Search");
    }
// end::pageObjectTest[]
// tag::endTest[]
}
// end::endTest[]

