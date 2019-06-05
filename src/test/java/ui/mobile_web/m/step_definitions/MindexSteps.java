package ui.mobile_web.m.step_definitions;

import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.同时;
import cucumber.api.java.zh_cn.并且;
import cucumber.api.java.zh_cn.那么;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import runner.BaseSteps;
import ui.mobile_web.m.pageobjects.LoginPage;
import ui.mobile_web.m.pageobjects.MindexPage;
import ui.mobile_web.m.pageobjects.UserCenterPage;

public class MindexSteps extends BaseSteps{

    @假如("^我在M站首页\"([^\"]*)\"$")
    public void 我在m站首页(String index) throws Throwable {
       driver.get(index);
    }

    @并且("^点击我的$")
    public void 点击我的() throws Throwable {
        PageFactory.initElements(driver, MindexPage.class);
        wait.until(ExpectedConditions.elementToBeClickable(MindexPage.userCenter)).click();
    }

    @同时("^进入登录页面登录$")
    public void 进入登录页面登录() throws Throwable {
        PageFactory.initElements(driver, LoginPage.class);
        wait.until(ExpectedConditions.elementToBeClickable(LoginPage.userName)).sendKeys("li");
        wait.until(ExpectedConditions.elementToBeClickable(LoginPage.female)).click();
        wait.until(ExpectedConditions.elementToBeClickable(LoginPage.mobile)).sendKeys("15353551910");
        wait.until(ExpectedConditions.elementToBeClickable(LoginPage.imgCode)).sendKeys("1234");
        wait.until(ExpectedConditions.elementToBeClickable(LoginPage.smsCode)).sendKeys("123456");
        wait.until(ExpectedConditions.elementToBeClickable(LoginPage.submit)).click();
    }

    @那么("^登录成功$")
    public void 登录成功() throws Throwable {
        PageFactory.initElements(driver, UserCenterPage.class);
        Assert.assertTrue(UserCenterPage.header.isDisplayed());
    }
}
