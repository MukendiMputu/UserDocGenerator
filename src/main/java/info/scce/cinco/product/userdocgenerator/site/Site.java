package info.scce.cinco.product.userdocgenerator.site;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Site {
	
	public String sUrl;
	public String sUsername;
	public String sPassword;
	public String sDomain;
	public Properties props;
	
	public Site() {
		try {
			// Try loading the properties from config.properties file
			props = new Properties();
			FileInputStream fis = new FileInputStream("/UserDocGenerator/src/main/java/info/scce/cinco/product/userdocgenerator/config/config.properties");
			props.load(fis);
								
			sUrl = props.getProperty("url");
			sUsername = props.getProperty("username");
			sPassword = props.getProperty("password");
			sDomain = props.getProperty("domain");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getsUrl() {
		return sUrl;
	}
	
	public String getsUsername() {
		return sUsername;
	}
	
	public String getsPassword() {
		return sPassword;
	}
	
	public String getsDomain() {
		return sDomain;
	}
	
}
