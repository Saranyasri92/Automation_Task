package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		//tags = {"@scenario1"},
	features = "src/main/java/features/sales.feature"
	,glue= {"My_Store"}
		)

public class DemoRunner {

}
