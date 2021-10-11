package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
public class FacebookHomePage {

    WebDriver driver;

    //Home page elements
    @FindBy(className = "_8eso")
    public WebElement slogan;

    @FindBy(id = "email")
    public  WebElement loginEmailTextField;

    @FindBy(id = "pass")
    public  WebElement loginPasswordTextField;

    @FindBy(name = "login")
    public  WebElement loginButton;

    @FindBy(xpath = "//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy'][@data-testid='open-registration-form-button']")
    public  WebElement createNewAccountButton;

    @FindBy(linkText = "English (UK)")
    public WebElement englishLocaleURL;

    //*[@class='_9ay7'][text()='The email address you entered isn't connected to an account. ']
    @FindBy(className = "_9ay7")
    public WebElement emptyUsernameError;

    @FindBy(className = "_9ay7")
    public WebElement wrongPasswordError;

    @FindBy(className = "_9kpn")
    public WebElement wrongUsernameError;

    //Registration pop up elements
    @FindBy(name = "firstname")
    public  WebElement firstNameTextField;

    @FindBy(name = "lastname")
    public  WebElement surNameTextField;

    @FindBy(name = "reg_email__")
    public  WebElement emailTextField;

    @FindBy(name = "reg_email_confirmation__")
    public  WebElement confirmEmailTextField;

    @FindBy(name = "reg_passwd__")
    public  WebElement passwordTextField;

    @FindBy(id = "day")
    public  WebElement dayDropDown;

    @FindBy(id = "month")
    public  WebElement monthDropDown;

    @FindBy(id = "year")
    public  WebElement yearDropDown;

    @FindBy(xpath = "//span[@class='_5k_2 _5dba']/input[@value='2']")
    public  WebElement genderMaleRadioButton;

    @FindBy(name = "websubmit")
    public  WebElement signUpButton;

    @FindBy(xpath = "//div[@class='_5633 _5634 _53ij']")
    public  WebElement whatsYourNameError;

    @FindBy(xpath = "//*[@class='_5633 _5634 _53ij'][text()='Please enter a valid mobile number or email address.']")
    public  WebElement invalidEmailError;


    //Constructor
    public FacebookHomePage(WebDriver driver) {
        this.driver=driver;

        //Initialize elements
        PageFactory.initElements(driver,this);
    }

    //Methods to interact with elements
    public void setLoginEmail(String loginEmail){
        loginEmailTextField.clear();
        loginEmailTextField.sendKeys(loginEmail);
    }

    public void setLoginPassword(String LoginPassword) {
        loginPasswordTextField.clear();
        loginPasswordTextField.sendKeys(LoginPassword);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void clickEnglishLocale(){
        englishLocaleURL.click();
    }

    public boolean isEmptyUsernameErrorDisplayed() {
        return emptyUsernameError.isDisplayed();
    }

    public boolean isWrongPasswordErrorDisplayed() {
        return wrongPasswordError.isDisplayed();
    }

    public boolean isWrongUsernameErrorDisplayed() {
        return wrongUsernameError.isDisplayed();
    }

    public void clickCreateNewAccountButton(){
        createNewAccountButton.click();
    }

    public void setFirstNameTextField(String firstName) {
        firstNameTextField.clear();
        firstNameTextField.sendKeys(firstName);
    }

    public void setSurNameTextField(String surName) {
        surNameTextField.clear();
        surNameTextField.sendKeys(surName);
    }

    public void setEmailTextField(String email) {
        emailTextField.clear();
        emailTextField.sendKeys(email);
    }

    public void setConfirmEmailTextField(String email) {
        confirmEmailTextField.clear();
        confirmEmailTextField.sendKeys(email);
    }

    public void setPasswordTextField(String password) {
        passwordTextField.clear();
        passwordTextField.sendKeys(password);
    }

    public void clickDayDropDown(){
        dayDropDown.click();
    }

    public void selectDay(String day) {
        Select selectedDay = new Select(dayDropDown);
        selectedDay.selectByVisibleText(day);
    }

    public void clickMonthDropDown(){
        monthDropDown.click();
    }

    public void selectMonth(String month) {
        Select selectedMonth = new Select(monthDropDown);
        selectedMonth.selectByVisibleText(month);
    }

    public void clickYearDropDown(){
        yearDropDown.click();
    }

    public void selectYear(String year) {
        Select selectedYear = new Select(yearDropDown);
        selectedYear.selectByVisibleText(year);
    }

    public void clickGenderMaleRadioButton(){
        genderMaleRadioButton.click();
    }

    public void clickSignUpButton(){
        signUpButton.click();
    }

    public boolean isWhatsYourNameErrorDisplayed() {
        return whatsYourNameError.isDisplayed();
    }

    public boolean isInvalidEmailErrorDisplayed() {
        return invalidEmailError.isDisplayed();
    }

    public boolean isHomePageOpened() {

        if(slogan.getText().toString().contains("Facebook helps you connect and share with the people in your life."))
            return true;
        else return slogan.getText().toString().contains("يمنحك فيسبوك إمكانية التواصل مع الأشخاص ومشاركة ما تريد معهم.");
    }
}