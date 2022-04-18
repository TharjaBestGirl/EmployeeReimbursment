package com.jack.project1.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	public static WebDriver driver;

	@Given("User is on Home Page")
	public void user_is_on_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/");

	   // Maximizing window
	   //driver.manage().window().fullscreen();
	}

	@When("User Navigate to LogIn Page")
	public void user_navigate_to_log_in_page() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement login = driver.findElement(By.id("Login"));
		login.click();
		System.out.println("Title of the page is " + driver.getTitle());
	}

	@When("User enters {string} and {string}")
	public void user_enters_and(String un, String pwd) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement uname = driver.findElement(By.id("user"));
		WebElement password = driver.findElement(By.id("pass"));
		WebElement loginBtn = driver.findElement(By.id("LoginButton"));
		uname.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
	}
	
	@Then("Message displayed Login Successfully")
	public void message_displayed_login_successfully() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Login Successful...");
		//driver.quit();
	}
	
	@Then("User is on Employee Home Page")
	public void user_on_emp_home() {
		System.out.println("Title of the page is " + driver.getTitle());
	}
	
	@When("User Navigates to Reimbursements Page")
	public void user_navigates_to_reimburse() {
		WebElement login = driver.findElement(By.id("Reimburse"));
		login.click();
		System.out.println("Title of the page is " + driver.getTitle());
	}
	
	@And("User enters {string} and {string} and {string}")
	public void user_inputs_reimburse(String ty, String des, String amo) {
		WebElement type = driver.findElement(By.id("type"));
		WebElement desc = driver.findElement(By.id("desc"));
		WebElement amount = driver.findElement(By.id("amt"));
		WebElement loginBtn = driver.findElement(By.id("AddReimburse"));
		type.sendKeys(ty);
		desc.sendKeys(des);
		amount.sendKeys(amo);
		loginBtn.click();
	}
	
	@Then("Message states that Reimbursement is added")
	public void message_displayed_reimburse_added() {
		System.out.println("Reimbursement Added...");
	}
}