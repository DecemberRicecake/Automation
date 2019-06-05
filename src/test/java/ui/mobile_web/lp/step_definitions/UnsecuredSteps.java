package ui.mobile_web.lp.step_definitions;

import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.同时;
import cucumber.api.java.zh_cn.并且;
import cucumber.api.java.zh_cn.那么;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import runner.BaseSteps;
import ui.mobile_web.lp.pageobjects.LpSuccessPage;
import ui.mobile_web.lp.pageobjects.UnsecuredPage;


public class UnsecuredSteps extends BaseSteps {

    @假如("^在unsecured页面\"([^\"]*)\"$")
    public void 在unsecured页面(String index) throws Throwable {
        driver.get(index);
    }

    @并且("^输入unsecured的信息$")
    public void 输入unsecured的信息() throws Throwable {
        Thread.sleep(3000);
        int x = 1;
        while (x < 4){
            x++;
            PageFactory.initElements(driver, UnsecuredPage.class);
            UnsecuredPage.city.click();
            System.out.println(UnsecuredPage.cityname.getText());
            if (UnsecuredPage.cityname.getText().equals("上海")){
                break;
            }
            else {
                Thread.sleep(1000);
                PageFactory.initElements(driver, UnsecuredPage.class);
                UnsecuredPage.citylabel.click();
                System.out.println("UnsecuredPage城市没选中");
            }
        }
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(UnsecuredPage.username)).sendKeys("li");
        wait.until(ExpectedConditions.visibilityOf(UnsecuredPage.mobile)).sendKeys("13920190003");
        wait.until(ExpectedConditions.visibilityOf(UnsecuredPage.imgCode)).sendKeys("1234");
        wait.until(ExpectedConditions.visibilityOf(UnsecuredPage.smsCode)).sendKeys("123456");
        driver.executeScript("window.scrollBy(0,800)");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(UnsecuredPage.identity));
        wait.until(ExpectedConditions.elementToBeClickable(UnsecuredPage.identity)).click();
        Thread.sleep(1000);
        PageFactory.initElements(driver, UnsecuredPage.IdentityPage.class);
        wait.until(ExpectedConditions.elementToBeClickable(UnsecuredPage.IdentityPage.identity)).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(UnsecuredPage.salary));
        wait.until(ExpectedConditions.elementToBeClickable(UnsecuredPage.salary)).click();
        Thread.sleep(1000);
        PageFactory.initElements(driver, UnsecuredPage.SalaryPage.class);
        wait.until(ExpectedConditions.elementToBeClickable(UnsecuredPage.SalaryPage.salary)).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(UnsecuredPage.socialsecurityfund));
        wait.until(ExpectedConditions.elementToBeClickable(UnsecuredPage.socialsecurityfund)).click();
        Thread.sleep(1000);
        PageFactory.initElements(driver, UnsecuredPage.SocialSecuritySFundPage.class);
        wait.until(ExpectedConditions.elementToBeClickable(UnsecuredPage.SocialSecuritySFundPage.socialsecurityfund)).click();
        Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOf(UnsecuredPage.havehouse));
        wait.until(ExpectedConditions.elementToBeClickable(UnsecuredPage.havehouse)).click();
        wait.until(ExpectedConditions.elementToBeClickable(UnsecuredPage.havecar)).click();
        wait.until(ExpectedConditions.elementToBeClickable(UnsecuredPage.insuranceinfo)).click();
    }

    @同时("^点击unsecured的申请$")
    public void 点击unsecured的申请() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(UnsecuredPage.submit));
        wait.until(ExpectedConditions.elementToBeClickable(UnsecuredPage.submit)).click();
        Thread.sleep(3000);
    }

    @那么("^unsecured页面登录成功$")
    public void unsecured页面登录成功() throws Throwable {
        PageFactory.initElements(driver, LpSuccessPage.class);
        wait.until(ExpectedConditions.visibilityOf(LpSuccessPage.verifyflag));
        Assert.assertEquals("您的申请已提交" ,LpSuccessPage.verifyflag.getText());
        driver.quit();
    }
}
