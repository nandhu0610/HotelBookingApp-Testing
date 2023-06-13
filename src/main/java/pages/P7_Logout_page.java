package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseTest;

public class P7_Logout_page extends BaseTest {
	public P7_Logout_page(WebDriver driver){
		this.driver = driver;
		if (!driver.getTitle().equals("Adactin.com - Logout")) {
			throw new IllegalStateException(
					"This is not Log out Page, current page is: " + driver.getCurrentUrl());
		}
	}
	public P1_Login_page Goto_login() {
		driver.findElement(By.linkText(property_locators.getProperty("p7_to_login_from_logout"))).click();
		return new P1_Login_page(driver);
	}
	public boolean Validate_logout() {
		return driver.findElement(By.xpath("//*[contains(text(),'logged out')]")).isDisplayed();
	}
}
