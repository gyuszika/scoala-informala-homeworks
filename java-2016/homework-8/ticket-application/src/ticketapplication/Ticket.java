package ticketapplication;

import java.util.HashMap;
import java.util.Map;

public class Ticket {
	protected int quantity;
	protected int client;

	Map<String, Integer> ticket = new HashMap<String, Integer>();

	public int getClient() {
		return client;
	}

	public Ticket(int client, int quantity) {
		this.client = client;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void showSalesIncome() {
		System.out.println();
		System.out.println("Ticket and income stats:");

		int soldEarlyBirdTicket = (quantity - (quantity * 50 / 100)) - ticket.get("Early Bird Ticket");
		int soldNormalTicket = (quantity - (quantity * 65 / 100)) - ticket.get("Normal Ticket");
		int soldVipTicket = (quantity - (quantity * 85 / 100)) - ticket.get("VIP Ticket");

		System.out.println("Sold Early Bird Tickets: " + soldEarlyBirdTicket + " - Price: 50RON " + " - Income: "
				+ (soldEarlyBirdTicket * 50) + "RON");
		System.out.println("Sold Normal Tickets: " + soldNormalTicket + " - Price: 80RON " + " - Income: "
				+ (soldNormalTicket * 80) + "RON");
		System.out.println("Sold VIP Tickets: " + soldVipTicket + " - Price: 120RON " + " - Income: "
				+ (soldVipTicket * 120) + "RON");
		System.out.println();
		System.out.println("The total income from the sold tickets: "
				+ ((soldNormalTicket * 80) + (soldEarlyBirdTicket * 50) + (soldVipTicket * 120)) + "RON");

	}

	public void printTicketAvailability() {

		System.out.println();
		System.out.println("Available tickets remaining:");
		for (Map.Entry<String, Integer> ticketInfo : ticket.entrySet()) {
			String value = ticketInfo.getKey();
			int key = ticketInfo.getValue();
			System.out.println("Ticket category: " + value + ", Available: " + key);
		}
	}

	public void ticketPurchase() throws CategoryTicketsSoldoutException {
		
		if (quantity == 0) {
			throw new CategoryTicketsSoldoutException("Please add grater value than 0 for ticket quantity!");

		} else if (quantity - client < 0) {

			if (client / 17 > 0) {

				int newClient = client + (client / 17 * 2);
				int remaining = newClient - quantity;

				ticket.put("Early Bird Ticket", quantity - quantity);
				ticket.put("Normal Ticket", quantity - quantity);
				ticket.put("VIP Ticket", quantity - quantity);

				System.out.println("Remaining clients on wishlist: " + remaining);
			}

		} else if (client <= quantity * 50 / 100) {
			if (client / 17 > 0) {

				int newClient = client + (client / 17 * 2);
				int newQuantity = quantity - (client / 17 * 2);

				ticket.put("Early Bird Ticket", (quantity - (quantity * 50 / 100)) - client);
				if (newClient > newQuantity * 50 / 100) {
					ticket.put("Normal Ticket", quantity * 35 / 100 - (client / 17 * 2));
				} else {
					ticket.put("Normal Ticket", quantity * 35 / 100);
				}
				ticket.put("VIP Ticket", quantity * 15 / 100);
			}
			
		} else if ((client > quantity * 50 / 100) && (client <= quantity - (quantity * 15 / 100))) {
			
			if (client / 17 > 0) {
				int newClient = client + (client / 17 * 2);
				int newQuantity = quantity - (client / 17 * 2);

				ticket.put("Early Bird Ticket", quantity - quantity);

				ticket.put("Normal Ticket", quantity - client - (quantity * 15 / 100));
				if (newClient > newQuantity * 85 / 100) {
					ticket.put("VIP Ticket", quantity * 15 / 100 - (client / 17 * 2));
				} else {
					ticket.put("VIP Ticket", quantity * 15 / 100);

				}
			}

		} else if ((client > quantity * 50 / 100) && (client >= quantity - (quantity * 35 / 100))) {

			if (client / 17 > 0) {
				int newClient = client + (client / 17 * 2);

				ticket.put("Early Bird Ticket", quantity - quantity);
				ticket.put("Normal Ticket", quantity - quantity);
				if (newClient < quantity) {
					ticket.put("VIP Ticket", quantity - newClient);
				} else {
					int remaining = newClient - quantity;
					System.out.println();
					ticket.put("VIP Ticket", quantity - quantity);
					System.out.println("Remaining clients on wishlist: " + remaining);
				}
			}
		}
	}
}
