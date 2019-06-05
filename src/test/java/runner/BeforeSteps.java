package runner;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class BeforeSteps extends Config {
    @Before
    public void before(Scenario scenario) {
        parms.put(Thread.currentThread().getId(), scenario.getName());
//        for (Long key : parms.keySet()) {
//            String value = parms.get(key);
//            System.out.format("before ... %2d...%s", key, value);
//        }
    }
}
