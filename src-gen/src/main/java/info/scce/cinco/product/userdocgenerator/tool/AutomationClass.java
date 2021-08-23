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
			// User Credentials
				protected String username;
				protected String password;
				protected String browser
				protected WebElement element;
				public AutomationClass() {
					// Loading configuratiion properties
					username = "mukendi";
					password = "KKDxkXLgHwaHnnfA&7";
					browser = "firefox";
					driver = null;
					element = null;
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
