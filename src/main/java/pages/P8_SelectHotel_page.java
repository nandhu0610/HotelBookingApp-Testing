package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseTest;

//incomplete
public class P8_SelectHotel_page extends BaseTest {
	public P8_SelectHotel_page(WebDriver driver) {
		this.driver = driver;
//		if (!driver.getTitle().equals("Adactin.com - Select Hotel")) {
//			throw new IllegalStateException(
//					"This is incorrect Page, current page is: " + driver.getCurrentUrl());
//		}
	}

	public String Validate_location() {
		List<WebElement> loccheck = driver.findElements(By.xpath("//*[starts-with(@id,'location_')]"));
		return loccheck.get(0).getAttribute("value");
	}

	public String Validate_hotelname() {
		List<WebElement> htlcheck = driver.findElements(By.xpath("//*[starts-with(@id,'hotel_name_')]"));
		return htlcheck.get(0).getAttribute("value");
	}

	public String Validate_roomtype() {
		List<WebElement> rmtypcheck = driver.findElements(By.xpath("//*[starts-with(@id,'room_type_')]"));
		return rmtypcheck.get(0).getAttribute("value");
	}

	public String Validate_roomnum() {
		List<WebElement> rmnumcheck = driver.findElements(By.xpath("//*[starts-with(@id,'rooms_')]"));
		String roomnos= rmnumcheck.get(0).getAttribute("value"), rmns = "";
		for(int i=0;i<roomnos.length();i++) {
			if(roomnos.charAt(i)==' ') break;
			rmns=rmns+roomnos.charAt(i);
		}
		return rmns;
	}

	public String Validate_numofdays() {
		List<WebElement> dayscheck = driver.findElements(By.xpath("//*[starts-with(@id,'no_days_')]"));
		String days= dayscheck.get(0).getAttribute("value"), dys="";
		for(int i=0;i<days.length();i++) {
			if(days.charAt(i)==' ') break;
			dys=dys+days.charAt(i);
		}
		return dys;
	}

	public String Validate_pricepernight() {
		List<WebElement> pricecheck = driver.findElements(By.xpath("//*[starts-with(@id,'price_night_')]"));
		String perRate= pricecheck.get(0).getAttribute("value"),prrte;
		prrte=perRate.substring(6);
		return prrte;
	}

	public String Validate_totalprice() {
		List<WebElement> totpricecheck = driver.findElements(By.xpath("//*[starts-with(@id,'total_price_')]"));
		String totRate= totpricecheck.get(0).getAttribute("value"),totrte="";
		totrte=totRate.substring(6);
		return totrte;
	}
	public String Validate_checkin() {
		List<WebElement> arrcheck = driver.findElements(By.xpath("//*[starts-with(@id,'arr_date_')]"));
		return arrcheck.get(0).getAttribute("value");
	}

	public String Validate_checkout() {
		List<WebElement> depcheck = driver.findElements(By.xpath("//*[starts-with(@id,'dep_date_')]"));
		return depcheck.get(0).getAttribute("value");
	}

	public void Select_button() {
		List<WebElement> radio = driver.findElements(By.xpath("//*[starts-with(@id,'radiobutton_')]"));
		radio.get(0).click();
	}
	
	public P9_BookHotel_page Continue_button() {
		driver.findElement(By.id(property_locators.getProperty("p8_continue"))).click();
		return new P9_BookHotel_page(driver);
	}

	public P2_SearchHotel_page Cancel_button() {
		driver.findElement(By.id(property_locators.getProperty("p8_cancel"))).click();
		return new P2_SearchHotel_page(driver);
	}
}
