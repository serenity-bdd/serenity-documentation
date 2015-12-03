@RunWith(SerenityRunner.class)
public class SampleTest {

    @Steps
    TestSteps steps;

    @Test
    public void shouldExecuteThisTest() {
        steps.initialization(2);
        steps.when_example_action_for(1);
        steps.then_example_result_should_be(2);
    }
}