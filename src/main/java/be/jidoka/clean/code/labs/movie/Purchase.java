package be.jidoka.clean.code.labs.movie;

import java.time.DayOfWeek;
import java.util.ArrayList;

public class Purchase {

	private int runtime;
	private DayOfWeek dayOfWeek;
	private boolean loge;
	private boolean threeD;
	private double extraPrice;
	private double purchasePrice;
	private ArrayList<Ticket> tickets = new ArrayList<Ticket>() {};

	public Purchase(int runtime, DayOfWeek dayOfWeek, boolean loge, boolean threeD) {
		this.runtime = runtime;
		this.dayOfWeek = dayOfWeek;
		this.loge = loge;
		this.threeD = threeD;
	}

	public void calculateExtraTicketPrice() {
		if (this.threeD) {
			this.extraPrice += 3.0;
		}
		if (this.runtime > 120) {
			this.extraPrice += 1.5;
		}
		if (this.dayOfWeek == DayOfWeek.SATURDAY || this.dayOfWeek == DayOfWeek.SUNDAY) {
			this.extraPrice += 1.5;
		}
		if (this.loge) {
			this.extraPrice += 2.0;
		}
	}

	public void addTicket(Ticket ticket) {
		this.tickets.add(ticket);
	}

	public double checkMovieNight(){
		if (this.dayOfWeek == DayOfWeek.THURSDAY && this.tickets.size() < 20) {
			return 2.0;
		}
		else return 0.0;
	}

	public double calculateTotalPrice() {
		double movieNightPrice = this.checkMovieNight();

		if(this.tickets.size()>=20){
			this.tickets.forEach((ticket -> {
				this.purchasePrice+=ticket.CalculateGroupTicketPrice();
			}));
		}
		else{
			this.tickets.forEach((ticket -> {
				this.purchasePrice+=ticket.CalculateTicketPrice()-movieNightPrice;
			}));
		}


		return this.purchasePrice;
	}

	public double getExtraPrice() {
		return extraPrice;
	}


}
