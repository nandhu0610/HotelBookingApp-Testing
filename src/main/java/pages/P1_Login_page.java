package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseTest;

public class P1_Login_page extends BaseTest {
	public P1_Login_page(WebDriver driver) {
		this.driver = driver;
		if (!driver.getTitle().equals("Adactin.com - Hotel Reservation System")) {
			throw new IllegalStateException(
					"This is not Sign In Page, current page is: " + driver.getCurrentUrl());
		}
	}

	public void Enter_username(String user) {
		driver.findElement(By.id(property_locators.getProperty("p1_username"))).sendKeys(user);
	}

	public void Enter_password(String pass) {
		driver.findElement(By.id(property_locators.getProperty("p1_password"))).sendKeys(pass);
	}

	public P2_SearchHotel_page Login_button() {
		driver.findElement(By.id(property_locators.getProperty("p1_login_button"))).click();
		return new P2_SearchHotel_page(driver);
	}

	public P3_Forgotpassword_page Forgot_password() {
		driver.findElement(By.linkText(property_locators.getProperty("p1_forgot_pass"))).click();
		return new P3_Forgotpassword_page(driver);
	}

}
