package be.jidoka.clean.code.labs.movie;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Calculator implements Bill {

	private Purchase purchase;

	@Override
	public void startPurchase(int runtime, DayOfWeek dayOfWeek, boolean loge, boolean threeD) {
		purchase = new Purchase(runtime,dayOfWeek,loge,threeD);

		purchase.calculateExtraTicketPrice();
	}

	@Override
	public void addTicket(int age, boolean student) {
		purchase.addTicket(new Ticket(age, student, this.purchase.getExtraPrice()));
	}

	@Override
	public double finishPurchase() {
		return purchase.calculateTotalPrice();
	}
}
