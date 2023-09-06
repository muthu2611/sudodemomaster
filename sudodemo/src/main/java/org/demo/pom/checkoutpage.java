package org.demo.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutpage {

WebDriver driver;
	
	public checkoutpage(WebDriver driver){
	
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="checkout")
	WebElement checkout;
	
	@FindBy(id="first-name")
	WebElement firname;
	
	@FindBy(id="last-name")
	WebElement lasname;
	
	@FindBy(id="postal-code")
	WebElement pincode;
	
	@FindBy(id="continue")
	WebElement proceed;
	
	

	public void ordercheckout(String fname, String lname , String pcode) throws InterruptedException{
		
		checkout.click();
		firname.sendKeys(fname);
		String text1=firname.getText();
		System.out.println(text1);
		Thread.sleep(2000);
		lasname.sendKeys(lname);
		String text2=firname.getText();
		System.out.println(text2);
		Thread.sleep(2000);
		pincode.sendKeys(pcode);
		String text3=firname.getText();
		System.out.println(text3);
		Thread.sleep(2000);
		proceed.click();
		
	}
		
	
}
