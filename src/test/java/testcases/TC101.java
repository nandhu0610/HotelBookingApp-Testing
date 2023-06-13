package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.P1_Login_page;
import pages.P2_SearchHotel_page;
import utilities.ReadExcel;

public class TC101 extends BaseTest {
	@BeforeClass
	public void file_assign() {
		filename = "TC-101";
	}

	@Test(dataProvider = "test", dataProviderClass = ReadExcel.class)
	public void TestCase101(String user, String pass) {
		P1_Login_page p1 = new P1_Login_page(driver);
		p1.Enter_username(user);
		p1.Enter_password(pass);
		P2_SearchHotel_page p2 = p1.Login_button();
		String loginuser = p2.Validate_login();
		Assert.assertEquals(loginuser, "Hello " + user + "!", "User not logged in");
	}

}
