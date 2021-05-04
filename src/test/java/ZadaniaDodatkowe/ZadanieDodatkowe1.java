package ZadaniaDodatkowe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;

public class ZadanieDodatkowe1 {

        private WebDriver driver;


        @Before
        public void setUp() {
            System.setProperty("webdriver.chrome.driver",
                    "src/main/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.get("https://prod-kurs.coderslab.pl/index.php");

        }

        @Test
        public void testShopSearch() {

            String[] products = {"t-shirt", "mug", "cushion", "notebook", "graphics", "poster"};
            Random random = new Random();


            for (int i = 0; i < products.length; i++) {

                int randomInteger = random.nextInt(50);

                WebElement element = driver.findElement(By.name("s"));
                element.clear();

                element.sendKeys(products[randomInteger % products.length]);
                element.submit();

                WebElement button = driver.findElement(By.id("_desktop_logo"));
                button.click();
                }
            }

            @After
            public void tearDown () {
                driver.quit();
            }
        }


