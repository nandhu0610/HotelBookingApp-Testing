package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseTest;
//incomplete
public class P5_BookedItenary_page extends BaseTest {

	public P5_BookedItenary_page(WebDriver driver) {
		this.driver = driver;
		if (!driver.getTitle().equals("Adactin.com - Select Hotel")) {
			throw new IllegalStateException(
					"This is incorrect Page, current page is: " + driver.getCurrentUrl());
		}
	}
	public void Search_box(String orderid) {
		driver.findElement(By.id(property_locators.getProperty("p5_searchbox"))).sendKeys(orderid);
	}
	public void Search_btn() {
		driver.findElement(By.id(property_locators.getProperty("p5_gobtn"))).click();
	}
	public void Cancelselected_btn() {
		driver.findElement(By.xpath(property_locators.getProperty("p5_cancelselected"))).click();
	}
	public P2_SearchHotel_page Searchhotel_button() {
		driver.findElement(By.id(property_locators.getProperty("p5_searchhotel"))).click();
		return new P2_SearchHotel_page(driver);
	}
	public P7_Logout_page Logout_btn() {
		driver.findElement(By.id(property_locators.getProperty("p5_logout"))).click();
		return new P7_Logout_page(driver);
	}
}
