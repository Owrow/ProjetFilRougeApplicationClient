package bo;

public class Message {
	private int id;
	private String message_text;
	private Client client;
	private Restaurant restaurant;

	public Message() {
		super();
	}

	public Message(String message_text, Client client, Restaurant restaurant) {
		super();
		this.message_text = message_text;
		this.client = client;
		this.restaurant = restaurant;
	}

	public Message(int id, String message_text, Client client, Restaurant restaurant) {
		super();
		this.id = id;
		this.message_text = message_text;
		this.client = client;
		this.restaurant = restaurant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage_text() {
		return message_text;
	}

	public void setMessage_text(String message_text) {
		this.message_text = message_text;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", message_text=" + message_text + ", client=" + client + ", restaurant="
				+ restaurant + "]";
	}


}
