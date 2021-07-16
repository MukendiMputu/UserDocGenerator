package info.scce.cinco.product.userdocgenerator.site;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Site {
	
	public String sBrowserName, sSiteURL, sUserName, sPassword;
	public Properties props;
	
	public Site() {
		try {
			// Try loading the properties from config.properties file
			props = new Properties();
			FileInputStream fis = new FileInputStream("/home/mukendi/eclipse-workspace/login-doc/src/main/java/com/example/config/config.properties");
			props.load(fis);
			
			sBrowserName = props.getProperty("browser");
			sSiteURL = props.getProperty("url");
			sUserName = props.getProperty("user");
			sPassword = props.getProperty("password");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getsBrowserName() {
		return sBrowserName;
	}

	public String getsSiteURL() {
		return sSiteURL;
	}

	public String getsUserName() {
		return sUserName;
	}

	public String getsPassword() {
		return sPassword;
	}
}
