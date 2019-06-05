package ui.mobile_web.m.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MindexPage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"tabbar\"]/ul/li[4]/a")
    public static WebElement userCenter;

}
