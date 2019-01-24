package ui.baidu_site.pageobjects;


import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class BaiduPage extends BaseClass {

    public BaiduPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(how= How.XPATH, using="//*[@id=\"kw\"]")
    public static WebElement search_box;

    @FindBy(how= How.XPATH, using="//*[@id=\"su\"]")
    public static WebElement submit;

}
