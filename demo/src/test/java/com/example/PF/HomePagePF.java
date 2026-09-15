package com.example.PF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePF {
    WebDriver driver;
    @FindBy(linkText = "Register")
    private WebElement register_link;

    @FindBy(css="[id='leftPanel'] h2")
    private WebElement messagelogin;

    @FindBy(css="[name=\"username\"]")
    private WebElement username;

    @FindBy(css="[name=\"password\"]")
    private WebElement password;

    @FindBy(css="[value=\"Log In\"]")
    private WebElement login_button;

    public HomePagePF(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void RegisterLink(){
        register_link.click();
    }

    public String getMessageLogin(){
        return messagelogin.getText();
    }

    public void Login(String username, String password ){
        this.password.sendKeys(password);
        this.username.sendKeys(username);
        this.login_button.click();
    }
}
