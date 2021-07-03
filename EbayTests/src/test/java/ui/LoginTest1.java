package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginTest1 {
	
	  WebDriver driver;
	  
	  @BeforeTest
	public void Startup() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://www.codecademy.com/");
		Thread.sleep(500);
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void CALogin() throws InterruptedException {
		WebElement loginMainBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div/header/div[1]/div/div/div/div[2]/div[2]/a"));
		loginMainBtn.click();
		WebElement uName = driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
		uName.sendKeys("twigsagi2@gmail.com");
		WebElement pw = driver.findElement(By.xpath("//*[@id=\"login__user_password\"]"));
		pw.sendKeys("Aa!987");
		Thread.sleep(1000);
		WebElement loginBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/main/div/div/div/div/div/div[1]/form/div/div[4]/div/button"));
		loginBtn.click();
	}
	
	@Test(priority=2)
	public void TitleCheck() throws InterruptedException {
		Thread.sleep(1000);
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "My Home | Codecademy";
		Assert.assertEquals(ActualTitle, ExpectedTitle,"Success");
	}
	
	@Test(priority=3)
	public void Logout() throws InterruptedException {
		Thread.sleep(5000);
		WebElement userOpt = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/header/div[1]/div/div/div/div[2]/div[3]/div/button"));		
		userOpt.click();
		Thread.sleep(1000);
		WebElement logoutBtn = driver.findElement(By.xpath("/html/body/div[20]/div[3]/div/div/div/div/div/div[5]/div/a/div"));	
		logoutBtn.click();
		
	}
	
	@Test(priority=4)
	public void TitleLogoutCheck() throws InterruptedException {
		Thread.sleep(1000);
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Log in | Codecademy";
		Assert.assertEquals(ActualTitle, ExpectedTitle,"Success");
	}
	
	@AfterTest
	public void Exit() {
		driver.quit();
	}

}
