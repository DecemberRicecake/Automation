package ui.m_baidu.step_definitions;

import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;
import drivers.AndroidStepDefs;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.m_baidu.pageobjects.m_BaiduPage;

import java.util.Set;

import static java.lang.Thread.sleep;


public class m_BaiduSteps extends AndroidStepDefs {
    @假如("^android手机打开\"([^\"]*)\"$")
    public void android手机打开(String BaiduIndex) throws Throwable {
        driver.get(BaiduIndex);                     //要先打开网页，才会有新的webview
        sleep(3000);
        Set<String> context = driver.getContextHandles();
        for(String contextName : context) {
            System.out.println(contextName);        //打印所有的Handle
        }
        driver.context("WEBVIEW_chrome");      //切换到webwview
    }

    @当("^在手机百度输入框内输入cucumber$")
    public void 在手机百度输入框内输入cucumber() throws Throwable {
        PageFactory.initElements(driver, m_BaiduPage.class);
        wait.until(ExpectedConditions.elementToBeClickable(m_BaiduPage.search_box)).sendKeys("cucumber");
        m_BaiduPage.submit.click();
    }

    @那么("^手机百度搜索到内容$")
    public void 手机百度搜索到内容() throws Throwable {
        System.out.println(driver.getCurrentUrl());
    }
}
