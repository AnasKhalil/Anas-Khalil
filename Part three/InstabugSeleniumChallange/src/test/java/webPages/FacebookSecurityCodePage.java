package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookSecurityCodePage {

    WebDriver driver;

    @FindBy(className = "uiHeaderTitle")
    public WebElement headerTitle;

    //Constructor
    public FacebookSecurityCodePage(WebDriver driver) {
        this.driver=driver;

        //Initialize elements
        PageFactory.initElements(driver,this);
    }

    //Methods to interact with elements
    public boolean isTitleThere(){
        return headerTitle.getText().toString().contains("Enter security code");
    }
}