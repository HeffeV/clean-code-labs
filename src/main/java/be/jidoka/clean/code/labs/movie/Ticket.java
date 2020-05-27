package be.jidoka.clean.code.labs.movie;

public class Ticket {
	private double price;
	private int age;
	private boolean student;

	public Ticket(int age,boolean student, double extraPrice) {
		this.age = age;
		this.student = student;
		this.price = extraPrice;
	}

	public double CalculateTicketPrice() {
		if (this.student) {
			this.price += 8.0;
		} else {
			if (this.age >= 65) {
				this.price += 6.0;
			}
			else if (this.age < 13) {
				this.price += 5.5;
			}
			else {
				this.price += 11.0;
			}
		}
		return this.price;
	}

	public double CalculateGroupTicketPrice() {
		return this.price+6;
	}
}
