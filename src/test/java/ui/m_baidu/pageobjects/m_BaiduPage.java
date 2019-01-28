package ui.m_baidu.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class m_BaiduPage {

    @FindBy(how= How.XPATH, using="//*[@id=\"index-kw\"]")
    public static WebElement search_box;

    @FindBy(how= How.XPATH, using="//*[@id=\"index-bn\"]")
    public static WebElement submit;

}
