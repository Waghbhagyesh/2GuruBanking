package org.xyz_PracticeTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActiTimeForVivek {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<WebElement> ids=driver.findElements(By.xpath("//div[@class='oxd-table-cell oxd-padding-cell']//div[starts-with(text(),'0')]"));
		int totalIds=ids.size();
		System.out.println("Total No Of ID's Available"+" "+totalIds);
		for(int i=0;i<totalIds-1;i++) {
			String IdToBeVerify=ids.get(i).getText();
			if(IdToBeVerify.equals("0038")) {
				System.out.println("Given Id Verify");
				System.out.println("Given Id is"+" "+IdToBeVerify);
				break;
			}else {
				System.out.println("Given Id Not Verify");
			}
			
		}

	}

}
