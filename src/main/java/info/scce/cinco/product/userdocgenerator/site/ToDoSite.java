package info.scce.cinco.product.userdocgenerator.site;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ToDoSite extends Site {

	// The pages of our website

	public ToDoSite() {
	}

	public Boolean Login() {
		return loginPage.Login(this.getsUserName(), this.getsPassword());
	}

	public void CloseSite() {
	}
}
