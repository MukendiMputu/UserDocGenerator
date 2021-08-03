package info.scce.cinco.product.userdocgenerator.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import info.scce.cinco.product.userdocgenerator.site.Site;

public class SmokeTest {
	
	Boolean bResult = false;
	Site site; 
	
	@BeforeMethod
	public void beforeMethod() {
		site = new Site();
	}
	
	@Test
	public void testCallFunction() throws InterruptedException {
		bResult = site.getsStartNode().isEmpty();
		Thread.sleep(3000);
		
		Assert.assertTrue(bResult, "Login failed");
	}
	
	@AfterMethod
	public void afterMethode() {
		
	}
}
