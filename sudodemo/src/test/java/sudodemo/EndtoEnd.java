package sudodemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EndtoEnd {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		List<WebElement> list=driver.findElements(By.xpath("//div[@class=\"inventory_item_label\"]//a"));
		
		for (WebElement ele : list) {
			if(ele.getText().equals("Sauce Labs Backpack")) {
				driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
			}
		}
		
		//driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("shopping_cart_container")).click();
		
		driver.findElement(By.id("checkout")).click();
		
		
		driver.findElement(By.id("first-name")).sendKeys("looksss");
		driver.findElement(By.id("last-name")).sendKeys("like");
		driver.findElement(By.id("postal-code")).sendKeys("909000");
		driver.findElement(By.id("continue")).click();
		
		String Price=driver.findElement(By.className("summary_info_label summary_total_label")).getText();
		System.out.println(Price);
		
		driver.findElement(By.id("finish")).click();
		
		String ordered=driver.findElement(By.className("complete-text")).getText();
		System.out.println(ordered);
		
		driver.findElement(By.id("back-to-products")).click();
		
		
		
		
		
	}

}
