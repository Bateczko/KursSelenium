package zadanie2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KatalonTest {

    private WebDriver driver;
    private String katalonTestUrl = "https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html";

    @Before
    public void setUp (){

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(katalonTestUrl);
    }

    @Test
    public void fillFormWithProperData(){

        // Wpisz imie

        String name = "Karol";

        WebElement firstNameInput = driver.findElement(By.id("first-name"));
        WebElement firstNameLabel = driver.findElement(By.xpath("//label[@for='first-name']"));

        if(firstNameInput.isEnabled()){
            firstNameInput.clear();
            firstNameInput.sendKeys(name);
            System.out.println(firstNameLabel.getText()+ ": " + name);
        } else {
            Assert.fail();
        }

        // Wpisz nazwisko

        String lastName = "Kowalski";

        WebElement lastNameInput = driver.findElement(By.id("last-name"));
        WebElement lastNameLabel = driver.findElement(By.xpath("//label[@for='last-name']"));

        if(lastNameInput.isEnabled()){
            lastNameInput.clear();
            lastNameInput.sendKeys(lastName);
            System.out.println(lastNameLabel.getText()+ ": " + lastName);
        } else {
            Assert.fail();
        }

        // Zaznacz plec

        WebElement gender = driver.findElement(By.xpath("//label[@class='radio-inline'][1]"));
        WebElement genderLabel = driver.findElement(By.xpath("//label[@for='gender']"));

        if(lastNameInput.isEnabled()){
            gender.click();
            System.out.println(genderLabel.getText()+ ": " + gender.getText());
        } else {
            Assert.fail();
        }

        // Wpisz date urodzenia

        String date = "05/22/2010";

        WebElement dateOfBirth = driver.findElement(By.id("dob"));
        WebElement dateOfBirthLabel = driver.findElement(By.xpath("//label[@for='dob']"));

        if(dateOfBirth.isEnabled()){
            dateOfBirth.clear();
            dateOfBirth.sendKeys(date);
            System.out.println(dateOfBirthLabel.getText()+ ": " + date);
        } else {
            Assert.fail();
        }


        // Wpisz adres

        String addressData = "Prosta 51";

        WebElement address = driver.findElement(By.id("address"));
        WebElement addressLabel = driver.findElement(By.xpath("//label[@for='address']"));


        if(address.isEnabled()){
            address.clear();
            address.sendKeys(addressData);
            System.out.println(addressLabel.getText() + ": " + addressData);
        } else {
            Assert.fail();
        }

        // Wpisz email

        String emailAddress = "karol.kowalski@mailinator.com";

        WebElement email = driver.findElement(By.id("email"));
        WebElement emailLabel = driver.findElement(By.xpath("//label[@for='email']"));

        if(email.isEnabled()){
            email.clear();
            email.sendKeys(emailAddress);
            System.out.println(emailLabel.getText() + ": " + emailAddress );
        } else {
            Assert.fail();
        }

        // Wpisz haslo

        String userPassword = "Pass123";
        WebElement password = driver.findElement(By.id("password"));
        WebElement passwordLabel = driver.findElement(By.xpath("//label[@for='password']"));


        if(password.isEnabled()){
            password.clear();
            password.sendKeys(userPassword);
            System.out.println(passwordLabel.getText() + ": " + userPassword);
        } else {
            Assert.fail();
        }

        // Wpisz nazwe firmy

        String companyData = "CodersLab";

        WebElement company = driver.findElement(By.id("company"));
        WebElement companyLabel = driver.findElement(By.xpath("//label[@for='company']"));


        if(company.isEnabled()){
            company.clear();
            company.sendKeys(companyData);
            System.out.println(companyLabel.getText() + ": " + companyData);
        } else {
            Assert.fail();
        }

        // Wpisz komentarz

        String commentText = "To jest mój pierwszy automat testow";

        WebElement comment = driver.findElement(By.id("comment"));
        WebElement commentLabel = driver.findElement(By.xpath("//label[@for='comment']"));


        if(comment.isEnabled()){
            comment.clear();
            comment.sendKeys(commentText);
            System.out.println(commentLabel.getText() + ": " + commentText);
        } else {
            Assert.fail();
        }

        // Potwierdz przyciskiem

        WebElement submit = driver.findElement(By.id("submit"));

        if(submit.isEnabled()){
            submit.click();
            System.out.println(submit.getText() + ": done" );
        } else {
            Assert.fail();
        }


    }

    @After
    public void tearDown() {
        //driver.quit();
    }
}
