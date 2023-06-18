package com.serenity.cucumber;

import org.junit.runner.RunWith;

import com.serenity.testbase.TestBase;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(features="src/test/resources/features/", tags="@POST")
public class SrenityCucumberStepDefination extends TestBase{

}
