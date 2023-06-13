package pages;

import org.openqa.selenium.WebDriver;

import base.BaseTest;

public class P6_Changepassword_page extends BaseTest {

	public P6_Changepassword_page(WebDriver driver) {
		this.driver = driver;
		if (!driver.getTitle().equals("Adactin.com - Search Hotel")) {
			throw new IllegalStateException(
					"This is incorrect Page, current page is: " + driver.getCurrentUrl());
		}
	}

}
