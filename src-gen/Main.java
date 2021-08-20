package info.scce.cinco.product.userdocgenerator.main;

import java.io.IOException; 
import info.scce.cinco.product.userdocgenerator.tool.AutomationClass;

public class Main {
	private static AutomationClass driverTool;
	// Here come all the configuration necessary to run the sequences in the browser
	
	public static void main (String[] args){
		driverTool = new AutomationClass();
		try {
			driverTool.openBrowser("firefox");
			driverTool.goToPage("http://localhost:8080");

			String sequenceName = "Login";

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

		}

	}
}
