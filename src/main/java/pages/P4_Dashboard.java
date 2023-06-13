package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseTest;

public class P4_Dashboard extends BaseTest {
	public P4_Dashboard(WebDriver driver) {
		this.driver = driver;
		if (!driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[1]")).getText()
				.equals("Welcome to Adactin Group of Hotels")) {
			throw new IllegalStateException("This is not dashboard " );
		}
	}

	public P2_SearchHotel_page Search_hotel() {
		driver.findElement(By.linkText(property_locators.getProperty("p4_search_hotel_link"))).click();
		return new P2_SearchHotel_page(driver);
	}

	public P5_BookedItenary_page Booked_Itenary() {
		driver.findElement(By.linkText(property_locators.getProperty("p4_booked_itenary_link"))).click();
		return new P5_BookedItenary_page(driver);
	}

	public P6_Changepassword_page Change_password() {
		driver.findElement(By.linkText(property_locators.getProperty("p4_change_pass_link"))).click();
		return new P6_Changepassword_page(driver);
	}

	public P7_Logout_page Logout() {
		driver.findElement(By.linkText(property_locators.getProperty("p4_logout_link"))).click();
		return new P7_Logout_page(driver);
	}
}
