package Zadanie8.page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddressPage {

    private static WebDriver driver;

    @FindBy(xpath = "//a[@title='View my customer account']")
    private static WebElement accountPageButton;

    @FindBy (xpath = "//*[@id='main']/header")
    private static WebElement pageHeaderMessage;

    @FindBy(xpath = "//a[contains(@id,'address')]")
    private static WebElement addFirstAddressButton;

    @FindBy(xpath = "//*[@data-link-action='add-address']")
    private static WebElement createNewAddressButton;

    @FindBy(name = "address1")
    private static WebElement addressInput;

    @FindBy(name = "postcode")
    private static WebElement postcodeInput;

    @FindBy(name = "city")
    private static WebElement cityInput;

    @FindBy(name = "id_country")
    private static WebElement countryInput;

    @FindBy(xpath = "//footer/button")
    private static WebElement saveButton;

    @FindBy(xpath = "//*[@role='alert']")
    private static WebElement message;

    @FindBy(xpath = "//*[@data-link-action='delete-address']")
    private static WebElement deleteButton;

    @FindBy(xpath = "//*[@id='_desktop_user_info']")
    private static WebElement signOutButton;

    @FindBy (xpath = "//*[@data-link-action='delete-address']")
    private static List <WebElement> deleteElements;


    public AddressPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static void clickAccountPageButton() {
        accountPageButton.click();
        Assert.assertEquals("Your account", pageHeaderMessage.getText());
    }

    public static void addNewAddress() {
        addFirstAddressButton.click();

        String urlAddAddress = "addresses";
        String url = driver.getCurrentUrl();
        //System.out.println("adres: " + url);

        //Porownanie adresow url
        if (url.contains(urlAddAddress)) {
            createNewAddressButton.click();
        }

        Assert.assertEquals("New address", pageHeaderMessage.getText());
    }

    public static void changeAddress (String address, String postcode, String city){
        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(address);

        postcodeInput.click();
        postcodeInput.clear();
        postcodeInput.sendKeys(postcode);

        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public static void selectCountry(){
        countryInput.click();
        Select roleDropDown = new Select(countryInput);
        roleDropDown.selectByValue("17");
    }

    public static void saveNewAddress(){
        saveButton.click();
    }

    public static void checkTheCorrectnessOfAddingANewAddress(){
        Assert.assertEquals("Address successfully added!", message.getText());
    }

    public static void deleteAddressAndLogOut(){
        //Mozliwosc usuniecia wszystkich dodanych adresow
//        int deleteElementsCount = deleteElements.size();
//        for (int i = 0; i < deleteElementsCount; i++){
//            deleteButton.click();
//        }
//
//        Assert.assertEquals("Address successfully deleted!", message.getText());
//        Assert.assertEquals(0, deleteElements.size());
        System.out.println("Liczba adresów użytkownika: " + deleteElements.size());

        signOutButton.click();
    }
}
