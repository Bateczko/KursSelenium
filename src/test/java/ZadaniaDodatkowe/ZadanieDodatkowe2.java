package ZadaniaDodatkowe;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class ZadanieDodatkowe2 {

    private WebDriver driver;
    int quantityOfUsers = 10;

    // Dane testowe

    String shopURL = "https://prod-kurs.coderslab.pl/index.php";

    String [] name = {"Anna","Agnieszka","Monika","Bogdan","Jacek","Igor","Piotr","Maria"};
    String [] surname = {"Kowalski", "Nowak", "Stach", "Kulka", "Kaczmarek", "Sobieski"};
    String [] emailAddress = {"@vp.pl", "@gmail.com", "@onet.pl", "@o2.pl"};
    String [] userPassword = {"12233", "3546526", "dfgdbsbbdaf", "edfbgfgb4", "465465ggfx"};
    String [] userDateOfBirth = {"02/12/1950", "12/04/1998", "05/05/2005", "04/04/2000"};
    String [] userCity = {"Krakow", "Wrcolaw", "Warszawa", "Gdansk", "Jarocin", "Kostrzyn nad Odra"};
    String [] userAddress = {"Piekna" , "Prosta", "Lesna", "Kreta", "Lotnicza", "Gorska", "Skrzynka"};



    Random random = new Random();



    @Before
    public void setUp (){

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(shopURL);
    }

    @Test
    public void testRegistration(){

        for (int i = 1; i <= quantityOfUsers; i++) {


            //Przejdz do strony logowania

            WebElement singIn = driver.findElement(By.xpath("//*[@id='_desktop_user_info']/div/a"));
            singIn.click();

            String actualTitle = driver.getTitle();
            String expectedTitle = "Login";

            Assert.assertEquals(actualTitle, expectedTitle);


            //Przejdź do strony rejestracji

            WebElement register = driver.findElement(By.xpath("//*[@id='content']/div/a"));
            register.click();


            //Wypelnij fomularz danymi

            //Wpisz imie

            WebElement firstName = driver.findElement(By.xpath("//input[@class='form-control'][@name='firstname']"));
            firstName.clear();

            int randomNumName = random.nextInt(name.length - 1);
            firstName.sendKeys(name[randomNumName]);


            //Wybierz plec
            char endLetter = name[randomNumName].charAt(name[randomNumName].length() - 1);
            if (endLetter == 'a') {
                WebElement titleMrs = driver.findElement((By.xpath("//input[@name='id_gender'][@value=2]")));
                titleMrs.click();
            } else {
                WebElement titleMr = driver.findElement((By.xpath("//input[@name='id_gender'][@value=1]")));
                titleMr.click();
            }


            //Wpisz nazwisko

            WebElement lastName = driver.findElement(By.xpath("//input[@class='form-control'][@name='lastname']"));
            lastName.clear();

            int randomNumSurname = random.nextInt(surname.length - 1);
            lastName.sendKeys(surname[randomNumSurname]);


            //Wpisz email
            WebElement email = driver.findElement(By.xpath("//input[@class='form-control'][@name='email']"));
            email.clear();

            int randomMail = random.nextInt(emailAddress.length - 1);
            int ranadomNumMail = random.nextInt(1000000);

            email.sendKeys(ranadomNumMail + emailAddress[randomMail]);


            //Wpisz haslo
            WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
            int randomPassword = random.nextInt(userPassword.length - 1);

            password.sendKeys(userPassword[randomPassword]);

            //Wpisz date urodzenia
            WebElement dateOfBirth = driver.findElement(By.xpath("//input[@name='birthday']"));
            String randomDateOfBirth = userDateOfBirth[random.nextInt(userDateOfBirth.length - 1)];

            dateOfBirth.sendKeys(randomDateOfBirth);


            //Zatwierdz formulaz
            WebElement save = driver.findElement(By.xpath("//*[@id='customer-form']/footer/button"));
            save.click();


            //Przejdz do konta uzytkownika
            WebElement acc = driver.findElement(By.xpath("//*[@id='_desktop_user_info']/div/a[2]/span"));
            acc.click();

            //Przejdz do podstrony z dresem
            WebElement homeAddress = driver.findElement(By.id("address-link"));
            homeAddress.click();


            //Wpisz adres zamieszkania
            WebElement address = driver.findElement(By.name("address1"));

            int randomNumAddress = random.nextInt(userAddress.length - 1);
            address.sendKeys(userAddress[randomNumAddress]);


            //Wpisz kod pocztowy
            WebElement postalCode = driver.findElement(By.name("postcode"));

            int firstPart = random.nextInt(99) + 10;
            int secondPart = random.nextInt(999) + 100;
            postalCode.sendKeys(firstPart + "-" + secondPart);

            //Wpisz miasto
            WebElement city = driver.findElement(By.name("city"));

            int randomCity = random.nextInt(userCity.length - 1);
            city.sendKeys(userCity[randomCity]);

            //Wybierz kraj
            Select dropCountry = new Select(driver.findElement(By.name("id_country")));
            dropCountry.selectByIndex(1);

            //Zatwierdz
            WebElement save1 = driver.findElement(By.xpath("//*[@id='content']/div/div/form/footer/button"));
            save1.click();
        }
}
    @After
    public void tearDown() {
        driver.quit();
    }
}



