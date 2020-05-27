package be.jidoka.clean.code.labs.movie;

import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;

import static org.assertj.core.api.Assertions.assertThat;

public class BillTest {

	private Bill bill;

	@Before
	public void setUp() {
		bill = new Calculator();
	}

	@Test
	public void generalAdmissionShouldEqualDefaultPrice() {
		// Arrange
		bill.startPurchase(100, DayOfWeek.WEDNESDAY, false, false);
		bill.addTicket(18, false);

		// Act
		double ticketPrice = bill.finishPurchase();

		// Assert
		assertThat(ticketPrice).isEqualTo(11.0);
	}

	@Test
	public void studentAdmissionShouldEqualStudentPrice() {
		bill.startPurchase(100, DayOfWeek.WEDNESDAY, false, false);
		bill.addTicket(18, true);

		double ticketPrice = bill.finishPurchase();

		assertThat(ticketPrice).isEqualTo(8.0);
	}

	@Test
	public void seniorAdmissionShouldEqualSeniorPrice() {
		bill.startPurchase(100, DayOfWeek.WEDNESDAY, false, false);
		bill.addTicket(70, false);

		double ticketPrice = bill.finishPurchase();

		assertThat(ticketPrice).isEqualTo(6.0);
	}

	@Test
	public void childAdmissionShouldEqualChildPrice() {
		bill.startPurchase(100, DayOfWeek.WEDNESDAY, false, false);
		bill.addTicket(12, false);

		double ticketPrice = bill.finishPurchase();

		assertThat(ticketPrice).isEqualTo(5.5);
	}

	@Test
	public void groupAdmissionShouldEqualGroupPrice() {
		bill.startPurchase(100, DayOfWeek.WEDNESDAY, false, false);
		for (int i = 0; i < 20; i++) {
			bill.addTicket(18, false);
		}

		double ticketPrice = bill.finishPurchase();

		assertThat(ticketPrice).isEqualTo(120.0);
	}

	@Test
	public void multipleGeneralAdmissionsShouldEqualDefaultPrice() {
		// Arrange
		bill.startPurchase(100, DayOfWeek.WEDNESDAY, false, false);
		bill.addTicket(18, false);
		bill.addTicket(18, false);

		// Act
		double ticketPrice = bill.finishPurchase();

		// Assert
		assertThat(ticketPrice).isEqualTo(22.0);
	}

	@Test
	public void _3DShouldAddToTicketPrice() {
		bill.startPurchase(100, DayOfWeek.WEDNESDAY, false, true);
		bill.addTicket(18, false);

		double ticketPrice = bill.finishPurchase();

		assertThat(ticketPrice).isEqualTo(14.0);
	}

	@Test
	public void overLengthAddToTicketPrice() {
		bill.startPurchase(130, DayOfWeek.WEDNESDAY, false, false);
		bill.addTicket(18, false);

		double ticketPrice = bill.finishPurchase();

		assertThat(ticketPrice).isEqualTo(12.5);
	}

	@Test
	public void weekendAddToTicketPrice() {
		bill.startPurchase(100, DayOfWeek.SUNDAY, false, false);
		bill.addTicket(18, false);

		double ticketPrice = bill.finishPurchase();

		assertThat(ticketPrice).isEqualTo(12.5);
	}

	@Test
	public void logeAddToTicketPrice() {
		bill.startPurchase(100, DayOfWeek.WEDNESDAY, true, false);
		bill.addTicket(18, false);

		double ticketPrice = bill.finishPurchase();

		assertThat(ticketPrice).isEqualTo(13.0);
	}

	@Test
	public void movieDaySubtractFromTicketPrice() {
		bill.startPurchase(100, DayOfWeek.THURSDAY, false, false);
		bill.addTicket(18, false);

		double ticketPrice = bill.finishPurchase();

		assertThat(ticketPrice).isEqualTo(9.0);
	}

	@Test
	public void movieDayGroupTicketPrice() {
		bill.startPurchase(100, DayOfWeek.THURSDAY, false, false);
		for (int i = 0; i < 20; i++) {
			bill.addTicket(18, false);
		}

		double ticketPrice = bill.finishPurchase();

		assertThat(ticketPrice).isEqualTo(120);
	}

	@Test
	public void movieDaySubtractMultipleTicketPrice() {
		bill.startPurchase(100, DayOfWeek.THURSDAY, false, false);
		for (int i = 0; i < 19; i++) {
			bill.addTicket(18, false);
		}

		double ticketPrice = bill.finishPurchase();

		assertThat(ticketPrice).isEqualTo(171.0);
	}


	// ZOMBIE

	// Zero
	// One /
	// Many /

	// Boundaries
	// Interface /
	// Exception

}
