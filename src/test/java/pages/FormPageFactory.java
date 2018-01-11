package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class FormPageFactory {
    WebDriver driver;

    @FindBy(css = "#fields_fname")
    WebElement Fname;

    @FindBy(css = "#fields_lname")
    WebElement Lname;

    @FindBy(css = "#fields_address1")
    WebElement Address;

    @FindBy(css = "#country")
    WebElement Country;

    @FindBy(css = "#fields_state")
    WebElement State;

    @FindBy(css = "#fields_city")
    WebElement City;

    @FindBy(css = "#fields_zip")
    WebElement Zip;


    @FindBy(css = "#fields_phone")
    WebElement Phone;

    @FindBy(css = "#fields_email")
    WebElement Email;

    @FindBy(css = ".rush_order_btn")
    WebElement Order_btn;

    public FormPageFactory(WebDriver driver) {    // constructor for the page
        this.driver = driver;
        PageFactory.initElements(driver, this);  //Webdriver driver, Object page -- will initiate abowe elements

    }

    public void fillFname() { Fname.sendKeys( "FakeFname");
    }

    public void fillLname() { Lname.sendKeys("FakeLname");
    }

    public void fillAddress() { Address.sendKeys("FakeAddress");
    }

    public void selectCountry(String country) {
        Select sel = new Select(Country);
        sel.selectByVisibleText(country);
    }

    public void selectState(String state) {
        Select sel = new Select(State);
        sel.selectByVisibleText(state);
    }

    public void fillCity() {
        City.sendKeys("FakeCity");
    }

    public void fillZip() {
        Zip.sendKeys("1010101");
    }

    public void fillPhone() {
        Phone.sendKeys("111111111");
    }

    public void fillEmail() {
        Email.sendKeys("a@a.com");
    }

    public void clickOrder() {
        Order_btn.click();
    }


    public void FormPage(String country, String state){

        fillFname();
        fillLname();
        fillAddress();
        selectCountry(country);
        selectState(state);
        fillCity();
        fillZip();
        fillPhone();
        fillEmail();
        clickOrder();

    }


}

