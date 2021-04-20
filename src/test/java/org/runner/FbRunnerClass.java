package org.runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;



@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources", glue = "org.fbstepDefinition", 
                 dryRun = false, monochrome = true,
                 snippets = SnippetType.CAMELCASE
                 ,tags = "not @Sanity")

public class FbRunnerClass {
	

}
