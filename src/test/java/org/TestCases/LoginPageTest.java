package org.TestCases;


import org.ObjectPages.POM;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest {
	WebDriver driver;

	@BeforeMethod()
	public void Setup(){
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
//		driver.manage().window().maximize();
		driver.get("http://www.demo.guru99.com/v4/");

	}

	@Test(dataProvider="inputCreds")
	public void Login(String username,String password,String scenario) {
		POM log=new POM(driver);
		BaseUtility util=new BaseUtility();
		log.enterUserId(username);
		log.enterPswd(password);
		log.clickOnLoginBtn();
		if(scenario.equals("invalid log cred")) {
			Assert.assertTrue(util.isAlertPresent(driver, 2));
			Alert alt=driver.switchTo().alert();
			System.out.println(alt.getText());
			alt.accept();
			System.out.println("GuruBank Cred Are InValid");
			
		}
		else {
			Assert.assertEquals(log.loginSuccessVerifier(), "Manger Id : mngr434853");
			System.out.println("GuruBank Cred Are Valid");	
		}
		// ScreenShot
		
	}
	@DataProvider
	public  Object[][] inputCreds(){
		Object data[][]= {
				{"mngr434853","Arupena","valid log cred"},
				{"mngr434852","Brupena","invalid log cred"},
				{"mngr434854","Crupena","invalid log cred"}
		};
		return data;
		
	}
	@AfterMethod()
	public void tearDown() {
		driver.close();
	}

}


