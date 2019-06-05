package ui.mobile_web.m.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserCenterPage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/h1")
    public static WebElement header;

}
