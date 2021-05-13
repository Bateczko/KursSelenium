package pageObjectPattern.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjectPattern.pages.LoginPage;
import pageObjectPattern.pages.UserInfoPage;

import java.util.concurrent.TimeUnit;

public class ChangeUserInfoSteps {

    private static WebDriver driver;

    private UserInfoPage userInfoPage;

    @Given("^User is logged in to CodersLab shop$")
    public void userIsLooggedInToCodersLabShop() {
        System.setProperty("webdriver.gecko.driver",
                "src/main/resources/drivers/geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("johnd@mail.com", "qwerty");

        userInfoPage = new UserInfoPage(driver);
    }

    @When("^User goes to UserInformationPage$")
    public void userGoesToUserInformationPage() {
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=identity");
    }

    @And("^User changes his birthday to \"([^\"]*)\"$")
    public void userChangesHisBirthdayTo(String date) {
        userInfoPage.setBirthdate(date);
    }

    @And("^User signs up for our newsletter$")
    public void userSignsUpForOurNewsletter() {
        userInfoPage.signInForNewsletter();
    }

    @And("^User saves information$")
    public void userSavesInformation() {
        userInfoPage.submitUserInfo("qwerty");
    }

    @Then("^User sees \"([^\"]*)\"$")
    public void userSees(String message) {
        Assert.assertEquals(message, userInfoPage.getUpdateInformation());
        driver.quit();
    }
}