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
import ui.mobile_web.lp.pageobjects.YixinPage;


public class YixinSteps extends BaseSteps {

    @假如("^在yixin页面\"([^\"]*)\"$")
    public void 在yixin页面(String index) throws Throwable {
        driver.get(index);
    }

    @并且("^输入yixin的信息$")
    public void 输入yixin的信息() throws Throwable {
        Thread.sleep(3000);
        int x = 1;
        while (x < 4){
            x++;
            PageFactory.initElements(driver, YixinPage.class);
            YixinPage.city.click();
            Thread.sleep(1000);
            PageFactory.initElements(driver, YixinPage.CityPage.class);
            try {
                YixinPage.CityPage.citychild.click();
                break;
            }
            catch (Exception e){
                System.out.println("YixinPage点击城市按钮失败");
            }
        }
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(YixinPage.username)).sendKeys("li");
        wait.until(ExpectedConditions.visibilityOf(YixinPage.mobile)).sendKeys("13920190013");
        wait.until(ExpectedConditions.visibilityOf(YixinPage.imgCode)).sendKeys("1234");
        wait.until(ExpectedConditions.visibilityOf(YixinPage.smsCode)).sendKeys("123456");
    }

    @同时("^点击yixin的申请$")
    public void 点击yixin的申请() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(YixinPage.submit));
        wait.until(ExpectedConditions.elementToBeClickable(YixinPage.submit)).click();
        Thread.sleep(3000);
    }

    @那么("^yixin页面登录成功$")
    public void yixin页面登录成功() throws Throwable {
        PageFactory.initElements(driver, LpSuccessPage.class);
        wait.until(ExpectedConditions.visibilityOf(LpSuccessPage.verifyflag));
        Assert.assertEquals("您的申请已提交" ,LpSuccessPage.verifyflag.getText());
        driver.quit();
    }
}
