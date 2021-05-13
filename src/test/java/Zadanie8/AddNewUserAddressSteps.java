package Zadanie8;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Zadanie8.page.AddressPage;
import pageObjectPattern.pages.LoginPage;
import java.util.concurrent.TimeUnit;

public class AddNewUserAddressSteps {

    private WebDriver driver;

    @Given("^User is logged in to shop$")
    public void userIsLoggedInToShop() {
        // Uruchom nowy egzemplarz przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver",
                    "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Google
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("jankowalski@vp.pl", "6434737235");

    }
    private AddressPage addressPage;

    @When("^User goes to Address page$")
    public void userGoesToAddressPage() {
        AddressPage addressPage = new AddressPage(driver);
        addressPage.clickAccountPageButton();
        addressPage.addNewAddress();
    }

    @And("^User inputs address, postcode, city$")
    public void userInputsAddressPostcodeCity() {
        AddressPage addressPage = new AddressPage(driver);
        addressPage.changeAddress("2 Marsham Street, Wellesley Road", "SW1P 4DF", "London");
    }

    @And("^User selects country$")
    public void userSelectsCountry() {
        AddressPage addressPage = new AddressPage(driver);
        addressPage.selectCountry();
    }

    @And("^User saves new address$")
    public void userSavesNewAddress() {
        AddressPage addressPage = new AddressPage(driver);
        addressPage.saveNewAddress();
    }

    @Then("^User see Address successfully added!$")
    public void userSeeAddressSuccessfullyAdded() {
        AddressPage addressPage = new AddressPage(driver);
        addressPage.checkTheCorrectnessOfAddingANewAddress();
    }

    @And("^User deletes address, and removes the address and logs out of the account$")
    public void userDeletesAddressAndRemovesTheAddressAndLogsOutOfTheAccount() {

        AddressPage addressPage = new AddressPage(driver);
        addressPage.deleteAddressAndLogOut();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
