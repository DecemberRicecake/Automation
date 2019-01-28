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

public abstract class AndroidStepDefs {
    protected AppiumDriver<MobileElement> driver;
    protected WebDriverWait wait;

    public AndroidStepDefs() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities=  new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true); //不初始
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "xiaomi");  //设备id
        capabilities.setCapability(MobileCapabilityType.UDID, "b8fa4d7c");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
//        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.browser");
//        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".BrowserActivity");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.chrome");   //测试apk包的名称
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.apps.chrome.Main");  //activity的名称
        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, 10);
    }
}
