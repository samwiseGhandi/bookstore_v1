package bookstore;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Order {
	double totalShippingFee, totalWeight, totalPrice;
	double shippingFee = 0.0;
	int amountOfBoxes = 1;
	boolean pickUp;
	List<Book> list = new ArrayList<Book>();
	
	public Order(boolean pickUp, List<Book> list) {
		this.pickUp = pickUp;
		this.list = list;
	}

	public double gettotalShippingFee() {
		amountOfBoxes = getAmountOfBoxes();
		if(amountOfBoxes > 5) {
			shippingFee = 90 * amountOfBoxes;
		} else {
			shippingFee = 150 * amountOfBoxes;
		}
		totalShippingFee = shippingFee;
		
		return totalShippingFee;
	}

	public double getTotalWeight() {
		totalWeight = 0.0;
		for(Book book : list) {
			totalWeight += book.getWeight();
		}
		return totalWeight;
	}

	public double getTotalPrice() {
		totalPrice = 0.0;
		for(Book book : list) {
			totalPrice += book.getPrice();
		}
		
		return totalPrice;
	}

	public int getAmountOfBoxes() {
		return (int) Math.ceil(list.size() / (double) 5);
	}

	public boolean isPickUp() {
		return pickUp;
	}

	public List<Book> getList() {
		return list;
	}
	
	public void printReceipt() {
		try {
			//please change this to the destination you want the receipt stored in
			BufferedWriter receipt = new BufferedWriter(new FileWriter("C:\\Users\\samel\\Desktop\\skola\\NewtonJava\\exercises\\bookstore\\receipt.txt"));
			receipt.write("Thank you for your purchase!" + "\n");
			receipt.write("Your order containing: " + " \n");
			for(Book book : list) {
				receipt.write("----------------------------------------" + "\n");
				receipt.write((list.indexOf(book) + 1) + ")");
				receipt.write("'" + book.getTitle() + "' by " + book.getAuthor() + ". `\n");
				receipt.write("Price: " + book.getIsbn() + "\n");
				receipt.write("Weight: " + book.getIsbn() + "\n");
				receipt.write("ISBN: " + book.getIsbn() + "\n");
				receipt.write("----------------------------------------" + "\n");
			}
			receipt.write("Total amount of books: " + list.size() + "\n");
			receipt.write("Total amount of boxes: " + getAmountOfBoxes() + "\n");
			receipt.write("Total weight of delivery: " + getTotalWeight() + "g" + "\n");
			receipt.write("\n");
			receipt.write("Total price of your order: " + (getTotalPrice() + gettotalShippingFee()) + " SEK" +  "\n");
			receipt.write("----------------------------------------" + "\n");
			receipt.write("If you decided to pick up you're order in the store your total price is:" + getTotalPrice() + "SEK" + "\n");
			
			receipt.close();
		} catch (Exception e) {
			return;
		}
	}

	
	
}
