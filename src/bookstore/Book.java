package bookstore;

public class Book {
	private String title, author, isbn;
	private double price, weight;
	
	public Book() {}

	

	public Book(String title, String author, String isbn, double price, double weight) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.weight = weight;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
