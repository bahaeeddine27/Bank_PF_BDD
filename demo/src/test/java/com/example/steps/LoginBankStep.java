package com.example.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Remote;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.example.PF.AccountOverviewPagePF;
import com.example.PF.HomePagePF;
import com.example.PF.RegisterPagePF;
import com.example.PF.WelcomeUserPagePF;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class LoginBankStep {
    WebDriver driver;
    HomePagePF hp;
    RegisterPagePF rg;
    WelcomeUserPagePF wu;
    AccountOverviewPagePF ap;
    URL gridUrl;

    @Before
    public void setUp() {
        try {
            gridUrl = new URL("http://selenium-hub:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ChromeOptions co = new ChromeOptions();
        driver = new RemoteWebDriver(gridUrl, co);
        hp = new HomePagePF(driver);
        rg = new RegisterPagePF(driver);
        wu = new WelcomeUserPagePF(driver);
        ap = new AccountOverviewPagePF(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("go to {string}")
    public void go_to(String s) {
        driver.get(s);
    }

    @When("Click the register button")
    public void Click_the_register_button() {
        hp.RegisterLink();
    }

    double randomnumber = Math.floor(Math.random() * 1000);

    @When("Signing up with FirstName {string}, LastName {string}, Address {string}, city {string}, state {string}, zipcode {string}, phone {string}, SSN {string}, Username {string}, password {string}")
    public void Signing_up_with_FirstName_LastName_Address_city_state_zipcode_phone_SSN_Username_password(String value1,
            String value2, String value3, String value4, String value5, String value6, String value7, String value8,
            String value9, String value10) {
        rg.FirstName(value1);
        rg.LastName(value2);
        rg.Address(value3);
        rg.City(value4);
        rg.State(value5);
        rg.Zipcode(value6);
        rg.phoneNumber(value7);
        rg.SSN(value8);
        rg.Username(value9 + randomnumber);
        rg.Password(value10 + randomnumber);
        rg.repeatedPassword(value10 + randomnumber);
    }

    @When("Click submit register")
    public void submit_register() {
        rg.RegisterSubmit();
    }

    @When("Verify the welcome message")
    public void verify_the_welcome_message() {
        assertTrue(wu.getWelcomeMessage().contains("Welcome"));
    }

    @When("Click LogOut")
    public void Click_LogOut() {
        wu.LogOutLink();
    }

    @When("Verify title login {string}")
    public void verify_title(String s) {
        assertEquals(s, hp.getMessageLogin());
    }

    @When("Enter Username {string} and password {string}")
    public void Enter_Username_and_password(String value1, String value2) {
        hp.Login(value1 + randomnumber, value2 + randomnumber);
    }

    @Then("Verify title {string}")
    public void Verify_title(String value1) {
        assertEquals(value1, ap.getTitle());
    }

}
