package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.BaseTest;

public class P9_BookHotel_page extends BaseTest {
	
	public P9_BookHotel_page(WebDriver driver) {
		this.driver = driver;
//		if (!driver.getTitle().equals("Adactin.com - Book A Hotel")) {
//			throw new IllegalStateException(
//					"This is incorrect Page, current page is: " + driver.getCurrentUrl());
//		}
	}
	public String Verify_hotelname() {
		String htlcheck = driver.findElement(By.id("hotel_name_dis")).getAttribute("value");
		return htlcheck;
	}
	public String Verify_location() {
		String loccheck = driver.findElement(By.id("location_dis")).getAttribute("value");
		return loccheck;
	}
	public String Verify_roomtype() {
		String typecheck = driver.findElement(By.id("room_type_dis")).getAttribute("value");
		return typecheck;
	}
	public String Verify_roomnum() {
		String roomnos= driver.findElement(By.id("room_num_dis")).getAttribute("value"), rmns = "";
		for(int i=0;i<roomnos.length();i++) {
			if(roomnos.charAt(i)==' ') break;
			rmns=rmns+roomnos.charAt(i);
		}
		return rmns;
	}
	public String Verify_numofdays() {
		String days= driver.findElement(By.id("total_days_dis")).getAttribute("value"), count = "";
		for(int i=0;i<days.length();i++) {
			if(days.charAt(i)==' ') break;
			count=count+days.charAt(i);
		}
		return count;
	}
	public String Verify_pricepernight() {
		String perRate= driver.findElement(By.id("price_night_dis")).getAttribute("value"),prrte;
		prrte=perRate.substring(6);
		return prrte;
	}
	public String Verify_totalprice() {
		String totRate= driver.findElement(By.id("total_price_dis")).getAttribute("value"),totrte="";
		totrte=totRate.substring(6);
		return totrte;
	}
	public String Verify_GST() {
		String Rate= driver.findElement(By.id("gst_dis")).getAttribute("value"),gst="";
		gst=Rate.substring(6);
		return gst;
	}
	public String Verify_finalprice() {
		String finl= driver.findElement(By.id("final_price_dis")).getAttribute("value"),price="";
		price=finl.substring(6);
		return price;
	}
	
	public void Enter_firtname(String fname) {
		driver.findElement(By.id(property_locators.getProperty("p9_firstname"))).sendKeys(fname);
	}
	public void Enter_lastname(String lname) {
		driver.findElement(By.id(property_locators.getProperty("p9_lastname"))).sendKeys(lname);
	}
	public void Enter_address(String address) {
		driver.findElement(By.id(property_locators.getProperty("p9_address"))).sendKeys(address);
	}
	public void Enter_ccnum(String ccnum) {
		driver.findElement(By.id(property_locators.getProperty("p9_ccnum"))).sendKeys(ccnum);
	}
	public void Enter_cctype(String cctyp) {
		Select cctype=new Select(driver.findElement(By.id(property_locators.getProperty("p9_cctype"))));
		cctype.selectByVisibleText(cctyp);
	}
	public void Enter_ccexpire(String expmnth, String expyr) {
		Select month=new Select(driver.findElement(By.id(property_locators.getProperty("p9_expmonth"))));
		month.selectByVisibleText(expmnth);
		Select year=new Select(driver.findElement(By.id(property_locators.getProperty("p9_expyear"))));
		year.selectByVisibleText(expyr);
	}
	public void Enter_cvvnum(String cvv) {
		driver.findElement(By.id(property_locators.getProperty("p9_cvvnum"))).sendKeys(cvv);
	}
	public P10_BookingConfirm_page BookNow_btn() {
		driver.findElement(By.id(property_locators.getProperty("p9_booknow"))).click();
		return new P10_BookingConfirm_page(driver);
	}
	public P2_SearchHotel_page Cancel_btn() {
		driver.findElement(By.id(property_locators.getProperty("p9_cancel"))).click();
		return new P2_SearchHotel_page(driver);
	}
	public String Validate_firstname() {
		return driver.findElement(By.id("first_name_span")).getText();
	}
	public String Validate_lastname() {
		return driver.findElement(By.id("last_name_span")).getText();
	}
	public String Validate_address() {
		return driver.findElement(By.id("address_span")).getText();
	}
	public String Validate_creditnum() {
		return driver.findElement(By.id("cc_num_span")).getText();
	}
	public String Validate_credittype() {
		return driver.findElement(By.id("cc_type_span")).getText();
	}
	public String Validate_creditexpiry() {
		return driver.findElement(By.id("cc_expiry_span")).getText();
	}
	public String Validate_creditcvv() {
		return driver.findElement(By.id("cc_cvv_span")).getText();
	}
}
