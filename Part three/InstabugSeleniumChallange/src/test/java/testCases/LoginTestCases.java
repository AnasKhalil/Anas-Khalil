package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import webPages.FacebookHomePage;
import webPages.FacebookPostLoginHomePage;


import java.util.concurrent.TimeUnit;


public class LoginTestCases {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        //Setting the Chrome driver path in the project, so that it can run on any machine
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        //Adding implicit wait to prevent timing out as a result of not finding an element instantly and to increase efficiency
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Maximizing window for a better view
        driver.manage().window().maximize();
    }

    // ************************************ Login Scenarios ************************************\\

    //First scenario: Empty fields (negative scenario)
    @DataProvider(name="emptyFieldsDataset")
    public Object[][] getData1(){

        //Number of columns is number of attributes entered
        Object[][] data = new Object[1][2];

        data[0][0] = "";
        data[0][1] = "";

        return data;
    }
    @Test(dataProvider="emptyFieldsDataset")
    public void firstLoginScenario(String email, String password) {

        FacebookHomePage home = new FacebookHomePage(driver);
        FacebookPostLoginHomePage postLoginHome = new FacebookPostLoginHomePage((driver));

        //Assert if target page is opened successfully
        Assert.assertTrue(home.isHomePageOpened());

        //Checking locale and setting it to English if it was not
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", home.englishLocaleURL);
        if(home.englishLocaleURL.isDisplayed())
            home.clickEnglishLocale();

        //Fill up login fields
        home.setLoginEmail(email);
        home.setLoginPassword(password);

        home.clickLoginButton();

        //Assert if empty username error appeared successfully
        Assert.assertTrue(home.isEmptyUsernameErrorDisplayed());
    }


    //Second scenario: Correct mail & wrong pass (negative scenario)
    @DataProvider(name="correctMailWrongPassDataset")
    public Object[][] getData2() {

        //Number of columns is number of attributes entered
        Object[][] data = new Object[1][2];

        data[0][0] = "test_tioiklc_one@tfbnw.net";
        data[0][1] = "pass_123";

        return data;
    }
    @Test(dataProvider="correctMailWrongPassDataset")
    public void secondLoginScenario(String email, String password) {

        FacebookHomePage home = new FacebookHomePage(driver);

        //Assert if target page is opened successfully
        Assert.assertTrue(home.isHomePageOpened());

        //Checking locale and setting it to English if it was not
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", home.englishLocaleURL);
        if(home.englishLocaleURL.isDisplayed())
            home.clickEnglishLocale();

        //Fill up login fields
        home.setLoginEmail(email);
        home.setLoginPassword(password);

        home.clickLoginButton();

        //Assert if wrong password error appeared successfully
        Assert.assertTrue(home.isWrongPasswordErrorDisplayed());
    }


    //Third scenario: Wrong mail & correct pass (negative scenario)
    @DataProvider(name="wrongMailCorrectPassDataset")
    public Object[][] getData3() {

        //Number of columns is number of attributes entered
        Object[][] data = new Object[1][2];

        data[0][0] = "test_one@tfbnw.net";
        data[0][1] = "pass_135";

        return data;
    }
    @Test(dataProvider="wrongMailCorrectPassDataset")
    public void thirdLoginScenario(String email, String password) {

        FacebookHomePage home = new FacebookHomePage(driver);

        //Assert if target page is opened successfully
        Assert.assertTrue(home.isHomePageOpened());

        //Checking locale and setting it to English if it was not
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", home.englishLocaleURL);
        if(home.englishLocaleURL.isDisplayed())
            home.clickEnglishLocale();

        //Fill up login fields
        home.setLoginEmail(email);
        home.setLoginPassword(password);

        home.clickLoginButton();

        //Assert if wrong username error appeared successfully
        Assert.assertTrue(home.isWrongUsernameErrorDisplayed());
    }


    //Fourth scenario: Correct mail & correct pass (positive scenario)
    @DataProvider(name="correctMailCorrectPassDataset")
    public Object[][] getData4() {

        //Number of columns is number of attributes entered
        Object[][] data = new Object[1][2];

        data[0][0] = "test_tioiklc_one@tfbnw.net";
        data[0][1] = "pass_135";

        return data;
    }
    @Test(dataProvider="correctMailCorrectPassDataset")
    public void fourthLoginScenario(String email, String password) {

        FacebookHomePage home = new FacebookHomePage(driver);
        FacebookPostLoginHomePage postLoginHome = new FacebookPostLoginHomePage((driver));

        //Assert if target page is opened successfully
        Assert.assertTrue(home.isHomePageOpened());

        //Fill up login fields
        home.setLoginEmail(email);
        home.setLoginPassword(password);

        home.clickLoginButton();

        //Assert if login is successful
        Assert.assertTrue(postLoginHome.isUserLoggedIn());
    }

    @AfterMethod
    public void close(){
        driver.close();
    }
}