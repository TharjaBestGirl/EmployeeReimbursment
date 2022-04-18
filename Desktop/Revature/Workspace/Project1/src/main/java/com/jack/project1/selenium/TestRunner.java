package com.jack.project1.selenium;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
		features = "src/main/resources/features",
		glue = {"com.jack.project1.selenium"}
		)
@RunWith(Cucumber.class)
public class TestRunner {

}
