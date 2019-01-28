package drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class AndroidStepDefs {                 //不要用OPPO手机，调试模式经常被关掉
    protected AppiumDriver<MobileElement> driver;
    protected WebDriverWait wait;

    protected Thread createThread = new Thread() {
        public void run() {
            System.out.println("appium test starting...");
            DesiredCapabilities capabilities=  new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
            capabilities.setCapability(MobileCapabilityType.NO_RESET, true); //不初始
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "xiaomi");  //设备id
            capabilities.setCapability(MobileCapabilityType.UDID, "b8fa4d7c");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
            //capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.browser");
            //capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".BrowserActivity");
            //厂商自带浏览器，一般web view的debug开关都是关的，无法定位元素，所以用chrome for android
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.chrome");
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.apps.chrome.Main");  //activity的名称
            try {
                driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            wait = new WebDriverWait(driver, 10);
        }
    };

    // 定义关闭线程
    protected Thread shutdownThread = new Thread() {
        public void run() {
            System.out.println("appium test over...");
            driver.quit();
        }
    };

    public AndroidStepDefs() {
        // jvm关闭的时候先执行该线程钩子
        Runtime.getRuntime().addShutdownHook(shutdownThread);
        createThread.run();
    }
}


