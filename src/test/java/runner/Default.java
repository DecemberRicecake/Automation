package runner;

import cucumber.api.CucumberOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//gule这里配置为根目录，如果配置成ui目录的话，BeforeSteps文件就不会执行了
@CucumberOptions(glue = ".", plugin = {"json:target/json-cucumber-reports/cukejson.json",
		"testng:target/testng-cucumber-reports/cuketestng.xml" }, features = "src/test/resources/features/")
public class Default extends AbstractTestNGCucumberParallelTests {

//    private static long duration;

    @BeforeMethod
    public static void before() {
//        duration = System.currentTimeMillis();
        System.out.println("before method");
    }

    @AfterMethod
    public static void after() {
//        duration = System.currentTimeMillis() - duration;
//		System.out.println("DURATION - "+ duration);
        System.out.println("after method");
    }

}