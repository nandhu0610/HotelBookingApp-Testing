package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.P1_Login_page;
import pages.P2_SearchHotel_page;
import pages.P4_Dashboard;
import pages.P7_Logout_page;
import utilities.ReadExcel;

public class TC109 extends BaseTest {
	@BeforeClass
	public void file_assign() {
		filename = "TC-109";
	}

	@Test(dataProvider = "test", dataProviderClass = ReadExcel.class)
	public void TestCase109(String user, String pass, String loc, String htel, String rmtyp, String rmno, String adult,
			String child, double chkin, double chkout) {
		P1_Login_page p1 = new P1_Login_page(driver);
		p1.Enter_username(user);
		p1.Enter_password(pass);
		P2_SearchHotel_page p2 = p1.Login_button();
		String loginuser = p2.Validate_login();
		Assert.assertEquals(loginuser, "Hello " + user + "!", "User not logged in");
		
		P4_Dashboard p4=new P4_Dashboard(driver);
		P7_Logout_page p7= p4.Logout();
		Assert.assertEquals(p7.Validate_logout(), true, "Not Logged out");
	}

}
