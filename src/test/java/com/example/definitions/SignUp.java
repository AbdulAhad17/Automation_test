package com.example.definitions;

import java.time.Duration;

import com.example.Pages.signupPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;


public class SignUp {

    signupPage signup = new signupPage();
    public static WebDriver driver;
    public final static int TIMEOUT = 400;

    @Before
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
    }

    @Given("User is on gitLab page")
    public void OpengitLab() throws InterruptedException {
        Thread.sleep(500);
        driver.navigate().to("https://about.gitlab.com/");
        Thread.sleep(800);
    }


    @When("User click on Get free Trial button to navigates the GitLab Free Trial Signup Page")
    public void signupTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"be-navigation-desktop\"]/div/div/div[2]/a")).click();
    }


    @After
    public void teardown() {

        driver.quit();
    }


    @When("User creates a new account")
    public void userCreatesANewAccount() throws InterruptedException {
        signup.enterFirst_name();
        signup.enterLast_name();
        signup.enterUser_name();
        signup.enterUser_email();
        signup.enterPassword();

    }

    @Then("Account creation is successful")
    public void accountCreationIsSuccessful() throws InterruptedException {
        signup.clickContinue();
    }

    @When("User enters {} as empty")
    public void userEntersAsEmpty(String field) throws InterruptedException {
        signup.user_enters_field_as_empty(field);
    }

    @Then("Error message is displayed for {}")
    public void errorMessageIsDisplayedFor(String field) throws InterruptedException {
        signup.validate_enters_field_as_empty(field);
    }

    @When("User enters an invalid email format")
    public void userEntersAnInvalidEmailFormat() throws InterruptedException {
        signup.enterFirst_name();
        signup.enterLast_name();
        signup.enterUser_name();
        signup.enterUser_invalid_email();
    }

    @Then("Error message {string} is displayed")
        public void errorMessageIsDisplayed (String expectedErrorMessage){
            String actualErrorMessage = signup.getEmailErrorElement();
            Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        }

    @When("User enters weak Password")
    public void userEntersWeak() throws InterruptedException {
        signup.enterFirst_name();
        signup.enterLast_name();
        signup.enterUser_name();
        signup.enterUser_email();
        signup.enterWeakPassword();

    }

    @Then("Error message for weak password {string} is displayed")
    public void errorMessageForWeakPasswordIsDisplayed(String expectedErrorMessage) {
        String actualErrorMessage = signup.weakPassword();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }


    @Then("Error message for existing email {string} is displayed")
    public void errorMessageForExistingEmailIsDisplayed(String expectedErrorMessage) throws InterruptedException {
        String actualErrorMessage = signup.signUpError();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @When("User enters existing email")
    public void userEntersExistingEmail() throws InterruptedException {
        signup.enterFirst_name();
        signup.enterLast_name();
        signup.enterUser_name();
        signup.enterUser_existing_email();
        signup.enterPassword();

    }

    @And("User click on continue button")
    public void userClickOnContinueButton() throws InterruptedException {
        signup.clickContinue();
    }
}

