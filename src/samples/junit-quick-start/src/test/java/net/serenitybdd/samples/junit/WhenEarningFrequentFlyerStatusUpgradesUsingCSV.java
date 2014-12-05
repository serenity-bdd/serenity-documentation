package net.serenitybdd.samples.junit;

import net.serenitybdd.samples.junit.model.Status;
import net.serenitybdd.samples.junit.steps.TravellerStatusSteps;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.SerenityParameterizedRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

import static net.serenitybdd.samples.junit.model.Status.*;

// tag::testcase[]
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="test-data/status-levels.csv", separator=',')        //<1>
public class WhenEarningFrequentFlyerStatusUpgradesUsingCSV {

    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {0,     Bronze},
                {9999,  Bronze},
                {10000, Silver},
                {49999, Silver},
                {50000, Gold}
        });
    }

    private int kilometersTravelled;
    private Status expectedStatus;

    public WhenEarningFrequentFlyerStatusUpgradesUsingCSV(int kilometersTravelled,
                                                          Status expectedStatus) {
        this.kilometersTravelled = kilometersTravelled;
        this.expectedStatus = expectedStatus;
    }

    @Steps
    TravellerStatusSteps travellerSteps;

    @Test
    public void reallyShouldEarnNextStatusWithEnoughPoints() {
        // GIVEN
        travellerSteps.a_traveller_joins_the_frequent_flyer_program();

        // WHEN
        travellerSteps.the_traveller_flies(kilometersTravelled);

        // THEN
        travellerSteps.traveller_should_have_a_status_of(expectedStatus);
    }
}
// end::testcase[]

