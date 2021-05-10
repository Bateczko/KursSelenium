package BddZadanie7;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class CreateAccountSteps {

    WebDriver driver;
    //Random random = new Random();


    @Given("^user is on user is on gloaApps site$")
    public void userIsOnUserIsOnGloaAppsSite() {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qloapps.coderslab.pl/pl/logowanie?back=my-account");

    }

    @When("^user inputs email (.*) address into CREATE AN ACCOUNT section$")
    public void userInputsEmailAddressIntoCREATEANACCOUNTSection(String email) {

        //String [] emailAddress = {"@vp.pl", "@gmail.com", "@onet.pl", "@o2.pl"};

        WebElement emailElement = driver.findElement(By.id("email_create"));
        emailElement.clear();
        //int randomMail = random.nextInt(emailAddress.length - 1);
        //int randomNumMail = random.nextInt(1000000);
        emailElement.sendKeys(email);

    }

    @And("^user clicks Create an account button$")
    public void userClicksCreateAnAccountButton() {

        WebElement buttonCreateAccount = driver.findElement(By.id("SubmitCreate"));
        buttonCreateAccount.click();
    }

    @And("^user inputs name (.*) surname (.*) password (.*)$")
    public void userInputsNameKarol(String name, String surname, String password) {

        WebDriverWait wait = new WebDriverWait(driver, 100);

        WebElement name1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("customer_firstname")));
        name1.clear();
        name1.sendKeys(name);

        WebElement surnameElement = driver.findElement(By.id("customer_lastname"));
        surnameElement.clear();
        surnameElement.sendKeys(surname);

        WebElement passwordElement = driver.findElement(By.id("passwd"));
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    @And("^user inputs name (.*), surname (.*), password (.*)$")
    public void userInputsNameSurnamePassword(String name, String surname, String password) {

        WebElement nameElement = driver.findElement(By.id("customer_firstname"));
        nameElement.clear();
        nameElement.sendKeys(name);

        WebElement surnameElement = driver.findElement(By.id("customer_lastname"));
        surnameElement.clear();
        surnameElement.sendKeys(surname);

        WebElement passwordElement = driver.findElement(By.id("passwd"));
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    @And("^user selects the gender by (.*)$")
    public void userSelectsTheGender(String name) {

        char endLetter = name.charAt(name.length() - 1);

        if (endLetter == 'a') {
            WebElement titleMrs = driver.findElement((By.id("id_gender2")));
            titleMrs.click();
        } else {
            WebElement titleMr = driver.findElement((By.id("id_gender1")));
            titleMr.click();
        }
    }


    @And("^user clicks Register$")
    public void userClicksRegister() {
        WebElement button = driver.findElement(By.id("submitAccount"));
        button.click();
    }

    @Then("^user closes browser$")
    public void userClosesBrowser() {
        driver.quit();
    }
}
