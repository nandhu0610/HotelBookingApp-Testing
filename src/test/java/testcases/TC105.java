package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.P1_Login_page;
import pages.P2_SearchHotel_page;
import pages.P8_SelectHotel_page;
import utilities.DateAddFormat;
import utilities.ReadExcel;

public class TC105 extends BaseTest {
	@BeforeClass
	public void file_assign() {
		filename = "TC-105";
	}

	@Test(dataProvider = "test", dataProviderClass = ReadExcel.class)
	public void TestCase105(String user, String pass, String loc, String htel, String rmtyp, String rmno, String adult,
			String child, double chkin, double chkout) {
		P1_Login_page p1 = new P1_Login_page(driver);
		p1.Enter_username(user);
		p1.Enter_password(pass);
		P2_SearchHotel_page p2 = p1.Login_button();
		String loginuser = p2.Validate_login();
		Assert.assertEquals(loginuser, "Hello " + user + "!", "User not logged in");
		p2.Enter_location(loc);
		p2.Enter_hotel(htel);
		p2.Enter_roomtype(rmtyp);
		p2.Enter_num_of_rooms(rmno);
		p2.Enter_adultnum(adult);
		p2.Enter_childnum(child);
		DateAddFormat df=new DateAddFormat();
		p2.Enter_checkin(df.dateformat(chkin));
		p2.Enter_checkout(df.dateformat(chkout));
		P8_SelectHotel_page p8=p2.Submit_button();
		String exp_arr=p8.Validate_checkin();
		Assert.assertEquals(exp_arr, df.dateformat(chkin), "arrival date shown is wrong");
		String exp_dep=p8.Validate_checkout();
		Assert.assertEquals(exp_dep, df.dateformat(chkout), "departure date shown is wrong");
	}

}
