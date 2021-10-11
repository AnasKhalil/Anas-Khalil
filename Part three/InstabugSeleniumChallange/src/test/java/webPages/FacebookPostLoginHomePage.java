package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPostLoginHomePage {

    WebDriver driver;

    @FindBy(xpath = "//*[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7'][text()='test user one']")
    public WebElement userProfileName;

    //Constructor
    public FacebookPostLoginHomePage(WebDriver driver) {
        this.driver=driver;

        //Initialize elements
        PageFactory.initElements(driver,this);
    }

    //Methods to interact with elements
    public boolean isUserLoggedIn(){
        return userProfileName.getText().toString().contains("test user one");
    }
}
