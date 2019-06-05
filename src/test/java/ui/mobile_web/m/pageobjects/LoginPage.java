package ui.mobile_web.m.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"__layout\"]/div/div/main/div[1]/div")
    public static WebElement city;

    @FindBy(how = How.XPATH, using = "//*[@id=\"__layout\"]/div/div/main/div[2]/input")
    public static WebElement userName;

    @FindBy(how = How.XPATH, using = "//*[@id=\"__layout\"]/div/div/main/div[2]/div/div[2]")
    public static WebElement female;

    @FindBy(how = How.XPATH, using = "//*[@id=\"__layout\"]/div/div/main/div[3]/input")
    public static WebElement mobile;

    @FindBy(how = How.XPATH, using = "//*[@id=\"__layout\"]/div/div/main/div[4]/input")
    public static WebElement imgCode;

    @FindBy(how = How.XPATH, using = "//*[@id=\"__layout\"]/div/div/main/div[5]/input")
    public static WebElement smsCode;

    @FindBy(how = How.XPATH, using = "//*[@id=\"apply\"]")
    public static WebElement submit;

    public static class CityPage {

        @FindBy(how= How.XPATH, using="//*[@id=\"__layout\"]/div/div/main/div[8]/div/ul[1]/li[3]/a")
        public static WebElement city;

    }
}
