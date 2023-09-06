package org.demo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Login {

    WebDriver driver;
	
	public Login(WebDriver driver)
	{
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	//WebElement userEmails = driver.findElement(By.id("userEmail"));
	//PageFactory
	
	@FindBy(id="user-name")
	WebElement userEmail;
	
	@FindBy(id="password")
	WebElement passwordEle;
	
	@FindBy(id="login-button")
	WebElement submit;
	
	public void loginApplication(String uname,String password)
	{
		userEmail.sendKeys(uname);
		passwordEle.sendKeys(password);
		submit.click();
	}

}
