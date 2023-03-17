package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:features"},
        glue = {"stepDefinitions"},
        tags = "@all",
        dryRun = false,
//        publish = true, // For reporting on cloud
        plugin = {
                "pretty",
                "html:target/CucumberReport/CucumberReport.html",
                "json:target/CucumberReport/CucumberReport.json",
                "junit:target/CucumberReport/CucumberReport.xml"
        }
)
public class MyRunner extends AbstractTestNGCucumberTests {

}
