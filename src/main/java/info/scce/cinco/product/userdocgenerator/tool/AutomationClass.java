package info.scce.cinco.product.userdocgenerator.tool;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import java.io.FileInputStream;
import org.openqa.selenium.Keys;
import java.io.FileNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutomationClass {
	protected WebDriver driver;
	protected String sBrowserName, sSiteURL, sUserName, sPassword;
	protected WebElement element;
	protected Properties props;
	
	public AutomationClass() {
		try {
			// Try loading the properties from config.properties file
			props = new Properties();
			FileInputStream fis = new FileInputStream("/home/mukendi/Dokumente/TU Dortmund/Bachelor/10. Semester/Bachelorarbeit/cinco-2.1.2/runtime-EclipseApplication/UserDocGenerator/src/main/java/info/scce/cinco/product/userdocgenerator/config/config.properties");
			props.load(fis);
			
			sBrowserName = props.getProperty("browser");
			sSiteURL = props.getProperty("url");
			sUserName = props.getProperty("user");
			sPassword = props.getProperty("password");
			driver = null;
			element = null;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Boolean openBrowser(String sBrowserType) {

		// Set path to driver executable as system path
		if (sBrowserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/home/mukendi/opt/WebDriver/bin/geckodriver");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		
		return true;
	}
	
	public Boolean goToPage(String sSiteURL) {
		driver.get(sSiteURL);
		return true;
	}
	
	public Boolean takePageScreenshot(String folderName, String pictureName) throws IOException {
		//Use TakesScreenshot method to capture screenshot
		TakesScreenshot screenshot = (TakesScreenshot)driver;

		File source = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./"+folderName+"/" + pictureName + ".png"));
		
		return true;
	}
	
	public Boolean takeElementScreenshot(WebElement pElement, String folderName, String pictureName) throws IOException {
		//Capture single element screenshot
		File source = pElement.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./"+folderName+"/" + pictureName + ".png"));
		return true;
	}
	
	public void highlightElement(WebElement elem) {
		JavascriptExecutor jsExec = (JavascriptExecutor) driver;
		jsExec.executeScript("arguments[0].setAttribute('style','border: 2px solid red;');", elem);
	}

	public Boolean typeIn(String elementID, String contentText) {
		WebElement inputField = driver.findElement(By.id(elementID));
		highlightElement(inputField);
		inputField.sendKeys(contentText + Keys.TAB);

		return true;
	}

	public Boolean pressEnter(){
		WebElement enterBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		highlightElement(enterBtn);
		enterBtn.click();;

		return true;
	}
	
	public void closeBrowser() {
		driver.quit();
	}
}
