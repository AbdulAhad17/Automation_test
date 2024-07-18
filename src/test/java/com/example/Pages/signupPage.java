package com.example.Pages;
//import com.github.javafaker.Faker;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static com.example.definitions.SignUp.driver;

public class signupPage {
     Faker faker = new Faker();
    private WebDriverWait wait;

    //Locator for FirstName field
    By First_name = By.id("new_user_first_name");

    //Locator for LastName field
    By Last_name = By.id("new_user_last_name");

    //Locator for UserName
    By user_name = By.id("new_user_username");

    //Locator for Email button
    By User_Email = By.id("new_user_email");

    //Locator for Password
    By User_Password = By.id("new_user_password");

    //Locator for continue button
    By continue_button = By.xpath("//*[@id=\"new_new_user\"]/button");
    By invalid_email_message = By.xpath("//*[@id=\"new_new_user\"]/div[5]/p[1]");
    By weak_password_message = By.xpath("//*[@id=\"new_new_user\"]/div[6]/p[1]");
    By unsuccessful_Signup_message = By.xpath("//*[@id=\"content-body\"]/div[1]/div/div[2]/div");
    By first_name_validation_message = By.xpath("//*[@id=\"new_new_user\"]/div[3]/div[1]/p[1]");
    By last_name_validation_message = By.xpath("//*[@id=\"new_new_user\"]/div[3]/div[2]/p[1]");
    By user_name_validation_message = By.xpath("//*[@id=\"new_new_user\"]/div[4]/p[1]");
    By email_validation_message = By.xpath("//*[@id=\"new_new_user\"]/div[5]/p[1]");
    By password_validation_message = By.xpath("//*[@id=\"new_new_user\"]/div[6]/p[1]");

   String firstName = faker.name().firstName();
   String lastName = faker.name().lastName();
   String userName = faker.name().username();
   String email = faker.internet().emailAddress();
   String password = faker.internet().password();

    String a;


    //Method to enter FirstName
    public void enterFirst_name() throws InterruptedException {
       // WebElement FirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(First_name));
        driver.findElement(First_name).sendKeys(firstName);
        Thread.sleep(10);
    }

    public void enterLast_name() throws InterruptedException {
       // WebElement LastName = wait.until(ExpectedConditions.visibilityOfElementLocated(Last_name));
        driver.findElement(Last_name).sendKeys(lastName);
        Thread.sleep(10);
    }

    public void enterUser_name() throws InterruptedException {
       // WebElement UserName = wait.until(ExpectedConditions.visibilityOfElementLocated(user_name));
        driver.findElement(user_name).sendKeys(userName);
        Thread.sleep(10);
    }

    public void enterUser_email() throws InterruptedException {
      //  WebElement UserEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(User_Email));
        driver.findElement(User_Email).sendKeys(email);
        Thread.sleep(10);
    }

    public void enterUser_invalid_email() throws InterruptedException {
        //  WebElement UserEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(User_Email));
        driver.findElement(User_Email).sendKeys("invalidemail");
        Thread.sleep(10);
    }
    public void enterPassword() throws InterruptedException {

      //  WebElement UserPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(User_Password));
        driver.findElement(User_Password).sendKeys(password);
        Thread.sleep(10);;
    }

    //Method to click on Login button
    public void clickContinue() throws InterruptedException {
        driver.findElement(continue_button).click();
        Thread.sleep(60);
    }

    public void user_enters_field_as_empty(String field) throws InterruptedException {
        switch (field) {
            case "First Name":
                driver.findElement(First_name).sendKeys("");
                Thread.sleep(200);
                enterLast_name();
                Thread.sleep(200);
                enterUser_name();
                Thread.sleep(200);
                enterUser_email();
                Thread.sleep(200);
                enterPassword();
                Thread.sleep(200);
                break;

            case "Last Name":
                driver.findElement(Last_name).sendKeys("");
                Thread.sleep(200);
                enterFirst_name();
                Thread.sleep(200);
                enterUser_name();
                Thread.sleep(200);
                enterUser_email();
                Thread.sleep(200);
                enterPassword();
                Thread.sleep(200);
                break;

            case "Email":
                driver.findElement(User_Email).sendKeys("");
                Thread.sleep(200);
                enterFirst_name();
                Thread.sleep(200);
                enterLast_name();
                Thread.sleep(200);
                enterUser_name();
                Thread.sleep(200);
                enterPassword();
                Thread.sleep(200);
                break;

            case "Password":
                driver.findElement(User_Password).sendKeys("");
                enterFirst_name();
                Thread.sleep(200);
                enterLast_name();
                Thread.sleep(200);
                enterUser_name();
                Thread.sleep(200);
                enterUser_email();
                Thread.sleep(200);

            case "User Name":
                driver.findElement(user_name).sendKeys("");
                enterFirst_name();
                Thread.sleep(200);
                enterLast_name();
                Thread.sleep(200);
                enterUser_email();
                Thread.sleep(200);
                enterPassword();
                Thread.sleep(200);

                break;
            default:
                throw new IllegalArgumentException("Invalid field: " + field);
        }
    }

    public void validate_enters_field_as_empty(String field) throws InterruptedException {
        switch (field) {
            case "First Name":
              String firstName_message =   driver.findElement(first_name_validation_message).getText();
              String firstName_expected_message = "This field is required.";
                Assert.assertEquals(firstName_message,firstName_expected_message);
                break;

            case "Last Name":
                String lastName_message =   driver.findElement(last_name_validation_message).getText();
                String lastName_expected_message = "This field is required.";
                Assert.assertEquals(lastName_message,lastName_expected_message);
                break;

            case "Email":
                String email_message =   driver.findElement(email_validation_message).getText();
                String email_expected_message = "Please provide a valid email address.";
                Assert.assertEquals(email_message,email_expected_message);
                break;

            case "Password":
                String password_message =   driver.findElement(password_validation_message).getText();
                String password_expected_message = "";
                Assert.assertEquals(password_message,password_expected_message);
                break;


            case "User Name":
                String User_name_message =   driver.findElement(user_name_validation_message).getText();
                String User_name_expected_message = "Please create a username with only alphanumeric characters.";
                Assert.assertEquals(User_name_message,User_name_expected_message);
                break;
            default:
                throw new IllegalArgumentException("Invalid field: " + field);
        }
    }


    public String weakPassword() {
        return String.valueOf(driver.findElement(weak_password_message).getText());
    }

    public String signUpError() throws InterruptedException {
        return String.valueOf(driver.findElement(unsuccessful_Signup_message).getText());
    }


    public void enterWeakPassword() throws InterruptedException {

        //  WebElement UserPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(User_Password));
        driver.findElement(User_Password).sendKeys("1a#");
        Thread.sleep(1000);;
    }

    public String getEmailErrorElement() {

        return String.valueOf(driver.findElement(invalid_email_message).getText());
    }

    public void enterUser_existing_email() throws InterruptedException {
        driver.findElement(User_Email).sendKeys("abdulahad_17@hotmail.com");
        Thread.sleep(10);;

    }
}
