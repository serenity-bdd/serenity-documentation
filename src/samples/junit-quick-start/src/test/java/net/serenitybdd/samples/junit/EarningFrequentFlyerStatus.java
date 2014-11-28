package net.serenitybdd.samples.junit;

import static net.serenitybdd.samples.junit.model.Status.*;

import net.serenitybdd.samples.junit.steps.TravellerStatusSteps;
import net.serenitybdd.samples.junit.steps.TravellerSteps;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

// tag::testcase[]
@RunWith(SerenityRunner.class)
public class EarningFrequentFlyerStatus {

    @Steps
    TravellerStatusSteps travellerSteps;

    @Test
    public void membersShouldStartWithBronzeStatus() {
        // GIVEN
        travellerSteps.a_traveller_joins_the_frequent_flyer_program();

        // THEN
        travellerSteps.traveller_should_have_a_status_of(Bronze);
    }

    @Test
    @Title(("Members need 1000 points to earn Silver status"))
    public void earnSilverAfter1000Points() {
        // GIVEN
        travellerSteps.a_traveller_joins_the_frequent_flyer_program();

        // WHEN
        travellerSteps.the_traveller_flies(10000);

        // THEN
        travellerSteps.traveller_should_have_a_status_of(Silver);
    }
}
// end::testcase[]

