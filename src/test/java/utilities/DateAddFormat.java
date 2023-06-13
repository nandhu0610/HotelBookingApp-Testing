package utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateAddFormat {

	public String dateformat(double days) {
		LocalDate today=LocalDate.now();
		LocalDate chin=today.plusDays((long) days);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String checkin = chin.format(formatter);
		return checkin;
		
	}
}
