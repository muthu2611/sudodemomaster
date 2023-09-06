package sudodemo;



import java.util.concurrent.TimeUnit;

import org.datate.Dataautomater;
import org.demo.pom.Login;
import org.demo.pom.cardpage;
import org.demo.pom.checkoutpage;
import org.demo.reuse.basecls;
import org.demo.util.Utility;
import org.demo.util.retryclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class FirstTest extends basecls{
	
	
	@Test (dataProvider="testfile",dataProviderClass = Dataautomater.class,priority= 1)
		   
	public void testone(String  uname, String password,String  fname, String lname,String pcode) throws InterruptedException {	
		Login login = new Login(driver);
		login.loginApplication(uname, password);

		
		cardpage card = new cardpage(driver);
		card.selectitem();
		card.addtocard();
		checkoutpage check = new checkoutpage(driver);
		
		check.ordercheckout(fname, lname, pcode); 
	}
	
	@Test (priority= 2)
	public void testtwo() {
		Login login = new Login(driver);
		login.loginApplication("stand", "secret");
		Assert.fail();
	}
	
}
