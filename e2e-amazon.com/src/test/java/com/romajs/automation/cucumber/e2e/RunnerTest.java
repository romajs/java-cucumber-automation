package com.romajs.automation.cucumber.e2e;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        tags = "",
        glue = "com.romajs.automation.cucumber.e2e.step",
        plugin = {"json:target/reports/CucumberReport.json", "pretty"},
        snippets = SnippetType.CAMELCASE
)
public class RunnerTest {
}
