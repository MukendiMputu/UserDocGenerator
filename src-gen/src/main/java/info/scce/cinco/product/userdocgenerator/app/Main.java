package info.scce.cinco.product.userdocgenerator.app;

import java.io.IOException;
import info.scce.cinco.product.userdocgenerator.tool.AutomationClass;

public class Main implements Runnable {

	public static void main (String[] args){
		Main main = new Main();
		main.run();
	}

	@Override
	public void run() {
		AutomationClass driverTool = new AutomationClass();
		// Start of sequence
		// For every doc in MGL generate a method with model name as signature
		driverTool.gotostart();
		try {
			driverTool.takePageScreenshot(this.getClass().toString(), "LoginPage");
			driverTool.typeIn("", "peter");
			driverTool.takePageScreenshot(this.getClass().toString(), "userCredentials");
			driverTool.typeIn("password", "pwd");
			driverTool.pressEnter();
			driverTool.takePageScreenshot(this.getClass().toString(), "UserDashboard");
			
			driverTool.closeBrowser();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
