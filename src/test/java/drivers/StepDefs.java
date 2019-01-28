package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class StepDefs {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected Thread createThread = new Thread() {
        public void run() {
            System.out.println("test starting...");
            System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 10);
        }
    };

    // 定义关闭线程
    protected Thread shutdownThread = new Thread() {
        public void run() {
            System.out.println("test over...");
            driver.quit();
        }
    };

    public StepDefs() {
        // jvm关闭的时候先执行该线程钩子
        Runtime.getRuntime().addShutdownHook(shutdownThread);
        createThread.run();
    }

}
