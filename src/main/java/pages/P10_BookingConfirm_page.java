package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseTest;

public class P10_BookingConfirm_page extends BaseTest {

	public P10_BookingConfirm_page(WebDriver driver) {
		this.driver = driver;
		if (!driver.getTitle().equals("Adactin.com - Hotel Booking Confirmation")) {
			throw new IllegalStateException(
					"This is incorrect Page, current page is: " + driver.getCurrentUrl());
		}
	}
	public P2_SearchHotel_page Search_hotel() {
		driver.findElement(By.id(property_locators.getProperty("p10_search"))).click();
		return new P2_SearchHotel_page(driver);
	}
	public P5_BookedItenary_page My_itenary() {
		driver.findElement(By.id(property_locators.getProperty("p10_itenary"))).click();
		return new P5_BookedItenary_page(driver);
	}
	public P7_Logout_page Logout() {
		driver.findElement(By.id(property_locators.getProperty("p10_logout"))).click();
		return new P7_Logout_page(driver);
	}
}
