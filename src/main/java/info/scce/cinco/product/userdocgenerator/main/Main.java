package info.scce.cinco.product.userdocgenerator.main;

import java.io.IOException;

import info.scce.cinco.product.userdocgenerator.tool.AutomationClass;

public class Main {
	private static AutomationClass driverTool;
	
	public static void main (String[] args){
		driverTool = new AutomationClass();
		try {
			driverTool.openBrowser("firefox");
			driverTool.goToPage("http://localhost:8080");
			Login("peter", "pwd");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Boolean Login(String sUserName, String sPassword) {
		Boolean bResult = true;
		String sequenceName = "Login";
		try {

			driverTool.goToPage("http://localhost:8080/home");
			driverTool.takePageScreenshot(sequenceName, "LoginPage");
			driverTool.typeIn("username", sUserName);
			driverTool.takePageScreenshot(sequenceName, "userCredentials");
			driverTool.typeIn("password", sPassword);
			Thread.sleep(5000);
			driverTool.pressEnter();
			driverTool.takePageScreenshot(sequenceName, "UserDashboard");

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			driverTool.closeBrowser();
		}

		return bResult;
	}
}
