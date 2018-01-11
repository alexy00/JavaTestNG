package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CCPageFactory {

    WebDriver driver;

    @FindBy(css = "#cc_number")
    WebElement CCNumber;

    @FindBy(css = "#fields_expmonth")
    WebElement ExpMonth;

    @FindBy(css = "#fields_expyear")
    WebElement ExpYear;

    @FindBy(css = "#cc_cvv")
    WebElement SecCode;

    @FindBy(css = ".trial-submit-button")
    WebElement SendButton;


    public CCPageFactory(WebDriver driver) {    // constructor for the page
        this.driver = driver;
        PageFactory.initElements(driver, this);  //Webdriver driver, Object page -- will initiate abowe elements

    }

    public void fillCCNumber(String ccnumber) { CCNumber.sendKeys(ccnumber);
    }


    public void selectMonth() {
        Select sel = new Select(ExpMonth);
        sel.selectByValue("12");
    }

    public void selectYear() {
        Select sel = new Select(ExpYear);
        sel.selectByValue("25");
    }

    public void fillSecCode(String seccode) {
        SecCode.sendKeys(seccode);
    }

    public void clickSend() {
        SendButton.click();
    }




    public void FillCC(String ccnumber, String seccode){
        fillCCNumber(ccnumber);
        selectMonth();
        selectYear();
        fillSecCode(seccode);
        clickSend();

    }





}
