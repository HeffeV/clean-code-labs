package be.jidoka.clean.code.labs.movie;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Calculator implements Bill {

	private final List<Double> ticketPrices = new ArrayList<>();
	private double extraPrice = 0.0;
	private DayOfWeek dayOfWeek;

	@Override
	public void startPurchase(int runtime, DayOfWeek dayOfWeek, boolean loge, boolean threeD) {
		this.dayOfWeek = dayOfWeek;

		if (threeD) {
			extraPrice += 3.0;
		}
		if (runtime > 120) {
			extraPrice += 1.5;
		}
		if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
			extraPrice += 1.5;
		}
		if (loge) {
			extraPrice += 2.0;
		}
	}

	@Override
	public void addTicket(int age, boolean student) {
		double ticketPrice = 0;

		if (student) {
			ticketPrice = 8.0;
		} else {
			if (age >= 65) {
				ticketPrice = 6.0;
			}
			else if (age < 13) {
				ticketPrice = 5.5;
			}
			else {
				ticketPrice = 11.0;
			}
		}

		ticketPrices.add(ticketPrice);
	}

	@Override
	public double finishPurchase() {
		double sum = 0.0;

		if (this.dayOfWeek == DayOfWeek.THURSDAY && ticketPrices.size() < 20) {
			extraPrice -= 2.0;
		}

		if (ticketPrices.size() >= 20) {
			sum = ticketPrices.size() * (6.0 + extraPrice);
		}
		else {
			for (Double ticketPrice : ticketPrices) {
				sum += ticketPrice + extraPrice;
			}
		}

		return sum;
	}
}
