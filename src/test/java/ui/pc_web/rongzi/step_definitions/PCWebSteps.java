package ui.pc_web.rongzi.step_definitions;

import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.那么;
import runner.BaseSteps;

public class PCWebSteps extends BaseSteps {

    @假如("^打开东融首页\"([^\"]*)\"$")
    public void 打开东融首页(String Index) throws Throwable {
        driver.get(Index);
    }

    @那么("^等待一段时间并打印标题$")
    public void 等待一段时间并打印标题() throws Throwable {
        System.out.println(driver.getTitle());
    }
}
