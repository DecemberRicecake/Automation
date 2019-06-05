package runner;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import static org.openqa.selenium.Proxy.ProxyType.MANUAL;
import static org.openqa.selenium.remote.CapabilityType.PROXY;

public class BaseSteps extends Config {
    protected RemoteWebDriver driver;
    protected WebDriverWait wait;
    protected BaseSteps() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.format("Thread%2d %s", Thread.currentThread().getId(), df.format(new Date()));

        Long thread_id = Thread.currentThread().getId();
        String scenario_name = parms.get(thread_id);
        parms.remove(thread_id);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        // 设置要启动的浏览器
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("71.0");
        // 设置是否实时查看 默认false
        capabilities.setCapability("enableVNC", true);
        // 设置是否录制视频 默认false
        capabilities.setCapability("enableVideo", true);
        // 设置录制视频名称，默认为session ID，名字一直不变的话，会覆盖掉原来的视频
        capabilities.setCapability("videoName", scenario_name + ".mp4");
        // 设置这次测试的名字
        capabilities.setCapability("name", scenario_name);

        String proxyDetails = "10.40.3.23:3128";
        org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
        proxy.setProxyType(MANUAL);
        proxy.setHttpProxy(proxyDetails);
        proxy.setSslProxy(proxyDetails);
        capabilities.setCapability(PROXY, proxy);

        ChromeOptions options = new ChromeOptions();        // chrome专有设置
        options.addArguments("disable-infobars");       // 隐藏"Chrome正在受到自动软件的控制"

        String ENV = System.getProperty("env");
        if( ENV.equals("PC") ){
            // 设置chrome的大小
            options.addArguments("--window-size=1920,1080");
            // 设置桌面屏幕的大小，不是浏览器的大小
            capabilities.setCapability("screenResolution", "1920x1080x24");
        }
        if( ENV.equals("Mobile") ){
            // 设置手机模式
            Map<String, String> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceName", "iPhone 6");
            options.setExperimentalOption("mobileEmulation", mobileEmulation);
            // 设置chrome的大小
            options.addArguments("--window-size=414,736");
            // 设置桌面屏幕的大小，不是浏览器的大小
            capabilities.setCapability("screenResolution", "1200x800x24");
        }
        // chrome专有设置
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        // 设置时区
        capabilities.setCapability("timeZone", "Asia/Shanghai");

        ResourceBundle resource = ResourceBundle.getBundle("config");
        String remoteurl = resource.getString("selenoid.hub");

        try {
            driver = new RemoteWebDriver(
                    // 连接selenoid
                    URI.create(remoteurl).toURL(),
                    capabilities
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        wait = new WebDriverWait(driver, 20);
    }

}


