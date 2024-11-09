import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class AuthorizationTest {

    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    public void checkLogIn() {

        WebDriver driver = factory.getDriver();
        var autPage = new AuthorizationPage(driver);

        autPage.logIn();
    }

    @Test
    public void checkErrorLogIn() {

        WebDriver driver = factory.getDriver();
        var autPage = new AuthorizationPage(driver);

        autPage.errorLogIn();
    }
}
