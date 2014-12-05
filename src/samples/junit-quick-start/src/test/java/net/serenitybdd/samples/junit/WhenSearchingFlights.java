package net.serenitybdd.samples.junit;

import net.serenitybdd.samples.junit.steps.FlightSearchSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

// tag::testcase[]
@RunWith(SerenityRunner.class)
public class WhenSearchingFlights {

    @Managed
    WebDriver driver;

    @Steps
    FlightSearchSteps theCustomer;

    @Test
    public void should_display_selected_flight_details() {

        // GIVEN
        theCustomer.searches_for_flights_between("Sydney", "London");

        // WHEN
        theCustomer.view_flight_details_for_flight(1);

        // THEN
        theCustomer.should_see_the_destination_city_in_the_summary();
    }
}
// end::testcase[]