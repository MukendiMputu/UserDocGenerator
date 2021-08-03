package info.scce.cinco.product.userdocgenerator.site;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Site {
	
	public String sStartNode;
	public String sEndNode;
	public String sFeatureContainer;
	public Properties props;
	
	public Site() {
		try {
			// Try loading the properties from config.properties file
			props = new Properties();
			FileInputStream fis = new FileInputStream("/home/mukendi/Dokumente/TU Dortmund/Bachelor/10. Semester/Bachelorarbeit/cinco-2.1.2/runtime-EclipseApplication/UserDocGenerator/src/main/java/info/scce/cinco/product/userdocgenerator/config/config.properties");
			props.load(fis);
								
			sStartNode = props.getProperty("startnode");
			sEndNode = props.getProperty("endnode");
			sFeatureContainer = props.getProperty("featurecontainer");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getsStartNode() {
		return sStartNode;
	}
	
	public String getsEndNode() {
		return sEndNode;
	}
	
	public String getsFeatureContainer() {
		return sFeatureContainer;
	}
	
}
