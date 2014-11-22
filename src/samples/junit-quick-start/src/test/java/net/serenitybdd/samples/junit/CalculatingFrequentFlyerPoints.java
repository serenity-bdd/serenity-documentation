package net.serenitybdd.samples.junit;

import net.serenitybdd.samples.junit.steps.TravellerSteps;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

// tag::testcase[]
@RunWith(SerenityRunner.class)                                                          // <1>
public class CalculatingFrequentFlyerPoints {

    @Steps                                                                              // <2>
    TravellerSteps travellerSteps;

    @Test
    public void shouldCalculatePointsBasedOnDistance() {
        // GIVEN
        travellerSteps.a_traveller_has_a_frequent_flyer_account_with_balance(10000);    // <3>

        // WHEN
        travellerSteps.the_traveller_flies(1000);                                       // <3>

        // THEN
        travellerSteps.traveller_should_have_a_balance_of(10100);                       // <3>

    }
}
// end::testcase[]

