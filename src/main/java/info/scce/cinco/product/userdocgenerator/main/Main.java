package info.scce.cinco.product.userdocgenerator.main;

import info.scce.cinco.product.userdocgenerator.site.Site;

public class Main {
	private static Site site;

	public Main () {
		site = new Site();
	}
	
	public static void main (String[] args){
		site.getsStartNode();
	}
}
