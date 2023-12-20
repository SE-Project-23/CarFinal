//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"cases"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        glue = {"org.example.test"},
        plugin = {"html:target/cucumber.html"}
)
public class AcceptanceTest {
    public AcceptanceTest() {
    }
}
