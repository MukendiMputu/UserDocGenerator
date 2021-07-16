package info.scce.cinco.product.userdocgenerator.pages;

import info.scce.cinco.product.userdocgenerator.tool.AutomationClass;

public class Page {
	
	public static AutomationClass driverTool;
	protected String sPageURL, sBrowserName, sClassName;
	
	public Boolean openPage() {
		return true;
	}

	public Boolean closePage() {
		return true;
	}
}

