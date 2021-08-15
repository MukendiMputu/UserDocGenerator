package info.scce.cinco.product.userdocgenerator.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import info.scce.cinco.product.userdocgenerator.main.Main;

public class SmokeTest {
	
	Boolean loggedIn = false;
	Main site; 
	
	@BeforeMethod
	public void beforeMethod() {
	}
	
	@Test
	public void testCallFunction() throws InterruptedException {
		loggedIn = Main.Login("peter", "pwd");
		Thread.sleep(3000);
		
		Assert.assertTrue(loggedIn, "Login failed");
	}
	
	@AfterMethod
	public void afterMethode() {
		
	}
}
