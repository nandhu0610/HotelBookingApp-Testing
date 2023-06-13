package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseTest;

public class P3_Forgotpassword_page extends BaseTest {

	public P3_Forgotpassword_page(WebDriver driver) {
		this.driver = driver;
		if (!driver.getTitle().equals("Adactin.com - Forgot Password")) {
			throw new IllegalStateException(
					"This is incorrect Page, current page is: " + driver.getCurrentUrl());
		}
	}

	public void Enter_Email(String email) {
		driver.findElement(By.id(property_locators.getProperty("p3_enter_email"))).sendKeys(email);
	}

	public void Reset_button() {
		driver.findElement(By.id(property_locators.getProperty("p3_forgot_pass_reset"))).click();
	}

	public void Email_password() {
		driver.findElement(By.id(property_locators.getProperty("p3_email_pass"))).click();
	}

	public P1_Login_page Go_Loginpage() {
		driver.findElement(By.linkText(property_locators.getProperty("p3_go_to_login"))).click();
		return new P1_Login_page(driver);
	}
}
