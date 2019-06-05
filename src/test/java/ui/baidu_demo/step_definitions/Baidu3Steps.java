package ui.baidu_demo.step_definitions;

import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.当;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import runner.BaseSteps;
import ui.baidu_demo.pageobjects.BaiduPage;

public class Baidu3Steps extends BaseSteps {
    @假如("^我在百度3首页\"([^\"]*)\"$")
    public void 我在百度3首页(String BaiduIndex) throws Throwable {
        driver.get(BaiduIndex);
    }

    @当("^输入日历$")
    public void 输入日历() throws Throwable {
        PageFactory.initElements(driver, BaiduPage.class);
        wait.until(ExpectedConditions.elementToBeClickable(BaiduPage.search_box)).sendKeys("日历");
        BaiduPage.submit.click();
        driver.quit();
    }
}
