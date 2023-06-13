package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import base.BaseTest;

public class P2_SearchHotel_page extends BaseTest {
	public P2_SearchHotel_page(WebDriver driver) {
		this.driver = driver;
		if (!driver.getTitle().equals("Adactin.com - Search Hotel")) {
			throw new IllegalStateException("This is incorrect Page, current page is: " + driver.getCurrentUrl());
		}
	}

	public String Validate_login() {
		String loginCheck = driver.findElement(By.id("username_show")).getAttribute("value");
		return loginCheck;
	}

	public void Enter_location(String loc) {
		Select location = new Select(driver.findElement(By.id(property_locators.getProperty("p2_location"))));
		location.selectByVisibleText(loc);
	}

	public void Enter_hotel(String htel) {
		Select hotel = new Select(driver.findElement(By.id(property_locators.getProperty("p2_hotels"))));
		hotel.selectByVisibleText(htel);
	}

	public void Enter_roomtype(String rmtyp) {
		Select roomtype = new Select(driver.findElement(By.id(property_locators.getProperty("p2_roomtype"))));
		roomtype.selectByVisibleText(rmtyp);
	}

	public void Enter_num_of_rooms(String rmno) {
		Select roomnumber = new Select(driver.findElement(By.id(property_locators.getProperty("p2_roomnos"))));
		roomnumber.selectByVisibleText(rmno);
	}

	public void Enter_adultnum(String adult) {
		Select adultbook = new Select(driver.findElement(By.id(property_locators.getProperty("p2_adult"))));
		adultbook.selectByVisibleText(adult);
	}

	public void Enter_childnum(String child) {
		Select childbook = new Select(driver.findElement(By.id(property_locators.getProperty("p2_child"))));
		childbook.selectByVisibleText(child);
	}

	public void Enter_checkin(String checkin) {
		driver.findElement(By.id(property_locators.getProperty("p2_checkin"))).clear();
		driver.findElement(By.id(property_locators.getProperty("p2_checkin"))).sendKeys(checkin);
	}

	public void Enter_checkout(String checkout) {
		driver.findElement(By.id(property_locators.getProperty("p2_checkout"))).clear();
		driver.findElement(By.id(property_locators.getProperty("p2_checkout"))).sendKeys(checkout);
	}

	public P8_SelectHotel_page Submit_button() {
		driver.findElement(By.id(property_locators.getProperty("p2_search"))).click();
		return new P8_SelectHotel_page(driver);
	}

	public String verify_roomnum() {
		return driver.findElement(By.id("num_room_span")).getText();
	}

	public String verify_loc() {
		return driver.findElement(By.id("location_span")).getText();
	}

	public String verify_checkin() {
		String check;
		try{
			check = driver.findElement(By.id("checkin_span")).getText();
		}catch(Exception e) {
			return "";
		}
		return check;
		
	}

	public String verify_checkout() {
		return driver.findElement(By.id("checkout_span")).getText();
	}

	public String verify_adultnum() {
		return driver.findElement(By.id("adults_room_span")).getText();
	}

	public void Reset_button() {
		driver.findElement(By.id(property_locators.getProperty("p2_reset"))).click();
	}
}
