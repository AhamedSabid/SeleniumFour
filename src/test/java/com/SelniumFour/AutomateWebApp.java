package com.SelniumFour;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

/**
 * Unit test for simple App.
 */
public class AutomateWebApp {
	/**
	 * Rigorous Test :-)
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	// @Test
	public void shouldAnswerWithTrue() throws InterruptedException, IOException {
		ChromeOptions co=new ChromeOptions();
		co.setHeadless(true);
		
		WebDriver driver = WebDriverManager.chromedriver().capabilities(co).create();
		// WebDriver driver = new ChromeDriver();

		// Navigate to the demoqa website
		driver.get("https://www.google.com");
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("Software");
		Thread.sleep(3000);
		WebElement logo = driver.findElement(By.xpath("//img[@alt='Google']"));
		logo.click();
		WebElement searchInput = driver.findElement(By.xpath("//input[@name='q']"));
		// WebElement searchBtn=
		// driver.findElement((By.xpath("//input").below(searchInput)));

		File file = logo.getScreenshotAs(OutputType.FILE);
		File destFile = new File("logoFileGoogle.png");
		FileUtils.copyFile(file, destFile);
		driver.quit();

	}

	// @Test
	public void NewTabOpen() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Navigate to the demoqa website
		driver.get("https://www.google.com");
		driver.manage().window().maximize();

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.Apple.com");
		Thread.sleep(3000);
		driver.quit();

	}

	// @Test
	public void NewWindowOpen() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Navigate to the demoqa website
		driver.get("https://www.google.com");
		driver.manage().window().maximize();

		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.Apple.com");
		Thread.sleep(3000);
		driver.quit();

	}

	@Test(description = "Verify window diamensions")
	@Description("Verify window diamensions")
	@Epic("EP001")
	@Feature("Feature3: Verify window diamensions")
	@Story("Story:User Window diamensions")
	@Severity(SeverityLevel.NORMAL)
	public void Location() throws InterruptedException, IOException {
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		ChromeOptions co=new ChromeOptions();
		co.setHeadless(true);
		
		WebDriver driver = WebDriverManager.chromedriver().capabilities(co).create();
		
		// Navigate to the demoqa website
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		WebElement logo = driver.findElement(By.xpath("//img[@alt='Google']"));

		System.out.println(logo.getRect().getDimension().getHeight());
		System.out.println(logo.getRect().getDimension().getWidth());

		System.out.println(logo.getRect().getX());
		System.out.println(logo.getRect().getY());

		Thread.sleep(3000);
		driver.quit();

	}
}
