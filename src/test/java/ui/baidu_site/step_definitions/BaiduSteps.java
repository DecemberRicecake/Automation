package ui.baidu_site.step_definitions;

import base.StepDefs;
import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.baidu_site.pageobjects.BaiduPage;

public class BaiduSteps extends StepDefs {
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @假如("^我在百度首页\"([^\"]*)\"$")
    public void 我在百度首页(String BaiduIndex) throws Throwable {
        driver.get(BaiduIndex);
    }

    @当("^输入cucumber$")
    public void 输入cucumber() throws Throwable {
        PageFactory.initElements(driver, BaiduPage.class);
        wait.until(ExpectedConditions.elementToBeClickable(BaiduPage.search_box)).sendKeys("cucumber");
        BaiduPage.submit.click();
    }

    @那么("^搜索到内容$")
    public void 搜索到内容() throws Throwable {
        System.out.println(driver.getCurrentUrl());
    }
}
