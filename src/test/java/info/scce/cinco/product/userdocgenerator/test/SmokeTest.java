package info.scce.cinco.product.userdocgenerator.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import info.scce.cinco.product.userdocgenerator.site.ConferenceRoomSite;

public class SmokeTest {
	
	Boolean bResult = false;
	ConferenceRoomSite site; 
	
	@BeforeMethod
	public void beforeMethod() {
		site = new ConferenceRoomSite();
	}
	
	@Test
	public void testCallFunction() throws InterruptedException {
		bResult =  site.Login();
		Thread.sleep(3000);
		
		Assert.assertTrue(bResult, "Login failed");
	}
	
	@AfterMethod
	public void afterMethode() {
		
	}
}
