package org.xyz_PracticeTest;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@autocomplete='off' and @class='_2IX_2- VJZDxU']")).sendKeys("7741828361");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Bhagyesh@627295");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
		
		
	}

	@Test
	public void Iphone() {
		
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("Iphone 13");
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		List<WebElement> totalName=driver.findElements(By.xpath("//div[starts-with(text(),'APPLE ')]"));
		int Size=totalName.size();
		System.out.println(Size);
//		for(int i=0;i>Size-1;i++) {
//			System.out.println(totalName.get(i).getText());
//		}
		
	}
	
}
