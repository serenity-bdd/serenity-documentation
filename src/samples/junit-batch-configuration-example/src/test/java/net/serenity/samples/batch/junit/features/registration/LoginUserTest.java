@RunWith(SerenityRunner.class)
public class LoginUserTest {
    @Steps
    UserActionSteps steps;

    @Test
    public void should_create_login_record_after_login() {
        // GIVEN
        final User user = new User("user.login", "user@mail.com");
        steps.given_registered_user(user);
        // WHEN
        steps.when_user_login();
        // THEN
        steps.then_one_login_record_should_exist();
    }

    @Test
    public void should_clean_login_records_after_logout() {
        // GIVEN
        final User user = new User("user.login", "user@mail.com");
        steps.given_registered_user(user);
        // WHEN
        steps.when_user_login();
        steps.when_user_logout();
        // THEN
        steps.then_login_record_should_not_exist();
    }

    @Test
    public void should_not_create_duplicate_records_during_parallel_login() {
        // GIVEN
        final User user = new User("user.login", "user@mail.com");
        steps.given_registered_user(user);
        // WHEN
        steps.when_user_login();
        steps.when_user_login();
        // THEN
        steps.then_one_login_record_should_exist();
    }

    @Test
    public void should_clean_login_records_after_session_expired() {
        // GIVEN
        final User user = new User("user.login", "user@mail.com");
        steps.given_registered_user(user);
        // WHEN
        steps.when_user_login();
        steps.when_user_session_expired();
        // THEN
        steps.then_login_record_should_not_exist();
    }
}
