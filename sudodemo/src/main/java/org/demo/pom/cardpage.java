package org.demo.pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cardpage {
	WebDriver driver;
	
	public cardpage(WebDriver driver)
	{
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class=\"inventory_item_label\"]//a")
	public List<WebElement> productNames;
	
	@FindBy(id="shopping_cart_container")
	WebElement addtoshoppingcard;

	public void selectitem(){
		
		for (WebElement ele : productNames) {
			if(ele.getText().equals("Sauce Labs Backpack")) {
				driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
			}
		}
	}
	
	public void addtocard() {
			addtoshoppingcard.click();
	}
	
	
	public void waittime() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
}
