import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {
                "pretty",
                "html:target/pretty",
                "json:target/cucumber-parallel/cucumber.json"
        },
        tags = {}
)
public class RunCukesTest {
}