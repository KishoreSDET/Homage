package runner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@Test
@CucumberOptions(features = "src/test/java/features",glue = {"steps", "hooks"}, monochrome= true, publish = true )
public class CucumberRunner extends AbstractTestNGCucumberTests{
	
	

}
