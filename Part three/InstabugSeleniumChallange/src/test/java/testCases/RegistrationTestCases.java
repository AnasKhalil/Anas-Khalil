package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import webPages.FacebookHomePage;
import webPages.FacebookSecurityCodePage;
import java.util.concurrent.TimeUnit;

public class RegistrationTestCases {

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

    // ************************************ Registration Scenarios ************************************\\

    //First scenario: Empty fields (negative scenario)
    @Test
    public void firstRegistrationScenario(){

        FacebookHomePage home = new FacebookHomePage(driver);

        //Assert if target page is opened successfully
        Assert.assertTrue(home.isHomePageOpened());

        //Checking locale and setting it to English if it was not
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", home.englishLocaleURL);
        if(home.englishLocaleURL.isDisplayed())
            home.clickEnglishLocale();

        //Opening registration form
        home.clickCreateNewAccountButton();

        //Clicking the signup button without filling any fields
        home.clickSignUpButton();

        //Assert if field errors appear
        Assert.assertTrue(home.isWhatsYourNameErrorDisplayed());
    }

    //Second scenario: Invalid email format (negative scenario)
    @DataProvider(name = "invalidRegistrationEmailDataset")
    public Object[][] getData5() {

        //Number of columns is number of attributes entered
        Object[][] data = new Object[1][7];

        data[0][0] = "Anas";
        data[0][1] = "Khalil";
        data[0][2] = "anas.khalil.com";
        data[0][3] = "P@ssw0rd19";
        data[0][4] = "4";
        data[0][5] = "May";
        data[0][6] = "1996";

        return data;
    }
    @Test(dataProvider = "invalidRegistrationEmailDataset")
    public void secondRegistrationScenario(String firstName, String surName, String email, String password, String day, String month, String year){

        FacebookHomePage home = new FacebookHomePage(driver);

        //Assert if target page is opened successfully
        Assert.assertTrue(home.isHomePageOpened());

        //Checking locale and setting it to English if it was not
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", home.englishLocaleURL);
        if(home.englishLocaleURL.isDisplayed())
            home.clickEnglishLocale();

        //Opening registration form
        home.clickCreateNewAccountButton();

        //Fill up registration fields
        home.setFirstNameTextField(firstName);
        home.setSurNameTextField(surName);
        home.setEmailTextField(email);
        home.setPasswordTextField(password);
        home.clickDayDropDown();
        home.selectDay(day);
        home.clickMonthDropDown();
        home.selectMonth(month);
        home.clickYearDropDown();
        home.selectYear(year);
        home.clickGenderMaleRadioButton();
        home.clickSignUpButton();

        //Assert if registration is successful (i.e., user moved to enter security code page)
        Assert.assertTrue(home.isInvalidEmailErrorDisplayed());
    }

    //Third scenario: Valid data (positive scenario)
    @DataProvider(name = "validRegistrationDataset")
    public Object[][] getData6() {

        //Number of columns is number of attributes entered
        Object[][] data = new Object[1][7];

        data[0][0] = "Anas";
        data[0][1] = "Khalil";
        data[0][2] = "test_tioiklc_one@tfbnw.net";
        data[0][3] = "P@ssw0rd19";
        data[0][4] = "4";
        data[0][5] = "May";
        data[0][6] = "1996";

        return data;
    }
    @Test(dataProvider = "validRegistrationDataset")
    public void thirdRegistrationScenario(String firstName, String surName, String email, String password, String day, String month, String year){

        FacebookHomePage home = new FacebookHomePage(driver);
        FacebookSecurityCodePage page = new FacebookSecurityCodePage(driver);

        //Assert if target page is opened successfully
        Assert.assertTrue(home.isHomePageOpened());

        //Checking locale and setting it to English if it was not
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", home.englishLocaleURL);
        if(home.englishLocaleURL.isDisplayed())
            home.clickEnglishLocale();

        //Opening registration form
        home.clickCreateNewAccountButton();

        //Fill up registration fields
        home.setFirstNameTextField(firstName);
        home.setSurNameTextField(surName);
        home.setEmailTextField(email);
        home.setConfirmEmailTextField(email);
        home.setPasswordTextField(password);
        home.clickDayDropDown();
        home.selectDay(day);
        home.clickMonthDropDown();
        home.selectMonth(month);
        home.clickYearDropDown();
        home.selectYear(year);
        home.clickGenderMaleRadioButton();
        home.clickSignUpButton();

        //Assert if registration is successful (i.e., user moved to enter security code page)
        Assert.assertTrue(page.isTitleThere());
    }

    @AfterMethod
    public void close(){
        driver.close();
    }
}
