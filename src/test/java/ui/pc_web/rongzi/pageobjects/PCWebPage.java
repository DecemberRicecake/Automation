package ui.pc_web.rongzi.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class PCWebPage {

    @FindBy(how= How.XPATH, using="//*[@id=\"kw\"]")
    public static WebElement search_box;

    @FindBy(how= How.XPATH, using="//*[@id=\"su\"]")
    public static WebElement submit;

}
