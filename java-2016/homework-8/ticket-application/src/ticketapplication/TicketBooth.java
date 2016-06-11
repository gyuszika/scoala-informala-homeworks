package ticketapplication;

public class TicketBooth {

	public static void main(String[] args) throws CategoryTicketsSoldoutException {

		Ticket t = new Ticket(140,154);
		t.ticketPurchase();
		t.printTicketAvailability();
		t.showSalesIncome();
	}
}
