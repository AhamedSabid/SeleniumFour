package com.SelniumFour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class RelativeLocators {
	
	WebDriver driver;
	RemoteWebDriver r;
	
	@BeforeTest
	public void RelativeLocatorsBeforeTest(){
		driver = WebDriverManager.edgedriver().create();
		//driver = new ChromeDriver();

		// Navigate to the demoqa website
		driver.get("https://automationbookstore.dev/");
		driver.manage().window().maximize();
		
	}
	
	//@Test
	public void RelativeLocatorsTest() {
		
	 driver.findElement(RelativeLocator.with(By.xpath("//li")).toLeftOf(By.id("pid6"))).click();
	}
	@Test(description = "Verify book detail tile is clickable")
	@Description("Verify book detail tile........")
	@Epic("EP002")
	@Feature("Feature3: Book store")
	@Story("Story:User Book store")
	@Severity(SeverityLevel. NORMAL)
	public void RelativeLocatorsTest2() {
		
	 driver.findElement(RelativeLocator.with(By.xpath("//li")).above(By.id("pid6"))).click();
	}
	@AfterTest
	public void close() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.quit();
	}

}
