package org.ObjectPages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POM {
	public WebDriver driver;

	
//	PageObject WebElement
	
	@FindBy(name = "uid")
	private WebElement userNameField;

	@FindBy(name="password")
	private WebElement passwordField;

	@FindBy(name="btnLogin")
	private WebElement loginBtn;

	@FindBy(xpath="//td[text()='Manger Id : mngr434853']")
	private WebElement userLoginVerifier;


// Constructor
	
	public POM(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}

	
//	Action Methods
	
	public void enterUserId(String uName) {
		userNameField.sendKeys(uName);
	}
	public void enterPswd(String pWord) {
		passwordField.sendKeys(pWord);
	}
	public void clickOnLoginBtn() {
		loginBtn.click();
	}
	public String loginSuccessVerifier() {
		String verifier=userLoginVerifier.getText();
		return verifier;
	}
	



}
