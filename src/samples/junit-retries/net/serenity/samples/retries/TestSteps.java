public class TestSteps {

    private static Integer counter = 2;

    @Step
    public void initialization(final int value) {
        action();
    }

    @Step
    public void when_example_action_for(final int value) {
        action();
        Assert.assertTrue(true);
    }

    @Step
    public void then_example_result_should_be(final int value) {
        action();
        Assert.assertTrue(--counter <= 0);
    }

    private void action() {
        //some action
    }
}