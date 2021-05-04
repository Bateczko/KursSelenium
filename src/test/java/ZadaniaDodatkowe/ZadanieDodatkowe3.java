package ZadaniaDodatkowe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ZadanieDodatkowe3 {

    WebDriver driver;
    private String shopURL = "https://prod-kurs.coderslab.pl/index.php";

    @Before
    public void setUp (){

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(shopURL);
    }

    @Test
    public void productFilteringFunction(){

        WebElement clothes = driver.findElement(By.id("category-3"));
        clothes.click();

        WebElement price1 = driver.findElement(By.id("facet_input_38571_0"));
        price1.click();

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
