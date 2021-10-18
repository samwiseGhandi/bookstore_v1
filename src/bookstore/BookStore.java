package bookstore;

import java.util.ArrayList;
import java.util.Scanner;

public class BookStore {
	public static void main(String[] args) {
		double amount = 0.0;
		
		ArrayList<Book> bookList = new ArrayList<Book>();
		bookList.add(new Book("It ends with us", "Colleen Hoover", "9781471156267", 114.0, 270.0));
		bookList.add(new Book("Dune", "Frank Herbert", "9780340960196", 123.0, 412));
		bookList.add(new Book("They both die at the end", "Adam Silvera", "9781471166204", 110.0, 270.0));
		bookList.add(new Book("By the sea", "Abdulrazek Gurnah", "9780747557852", 120.0, 209.0));
		bookList.add(new Book("Paradise", "Abdulrazek Gurnah", "9781565841635", 223.0, 210.0));
		bookList.add(new Book("Punk 57", "Douglas Penelope", "9781539427766", 162.0, 435.0));
		bookList.add(new Book("Pulp", "Charles Bukowski", "9789185379354", 65.0, 130.0));
		
		ArrayList<Book> cartList = new ArrayList<Book>();
		
		Scanner sc = new Scanner(System.in);
		
		int menu = 0;
		
		boolean quit = false;
		
		do {
			displayMenu();
			System.out.println("Please enter your choice:");
			menu = sc.nextInt();
			System.out.println();
			
			switch(menu) {
			case 1:
				for(Book book : bookList) {
					displayLibrary(book, bookList);
				}
				
				System.out.println("Please choose a book to add to your cart:");
				
				int pickedBookCase1 = sc.nextInt();
				
				if(pickedBookCase1 <= 0) {
					System.out.println("please pick a valid number");
					pickedBookCase1 = sc.nextInt();
				} else if(pickedBookCase1 > bookList.size()) {
					System.out.println("please pick a valid number");
					pickedBookCase1 = sc.nextInt();
				}
				
				Book chosenBookCase1 = null;
				for(Book book : bookList) {
					if(pickedBookCase1 - 1 == bookList.indexOf(book)) {
						chosenBookCase1 = book;
					}
				}
				
				cartList.add(bookList.get(pickedBookCase1 - 1));
				
				System.out.println();
				System.out.println("'" + chosenBookCase1.getTitle()+ "' by " + chosenBookCase1.getAuthor() + " has been added to your cart!");
				System.out.println();
				
				break;
			case 2:
				System.out.println("---------------- Your Cart ----------------");
				for(Book book : cartList) {
					displayCart(book, cartList);
				}
				
				System.out.println("Would you like to remove a book?");
				System.out.println("(Enter 1 for yes and 2 for no)");
				
				int deleteBook = sc.nextInt();
				if(deleteBook != 2) {
					if(deleteBook != 1) {
						System.out.println("Please enter a valid choice for yes(1) or no(2)");
						deleteBook = sc.nextInt();
					}
				}
				
				if(deleteBook == 1) {
					System.out.println();
					System.out.println("----------------------------");
					System.out.println("Please select the book you would like to remove from your cart: ");
					
					int pickedBookCase2 = sc.nextInt();
					
					int chosenBookCase2 = -1;
					for(Book book : bookList) {
						if(pickedBookCase2 - 1 == cartList.indexOf(book)) {
							chosenBookCase2 = cartList.indexOf(book);
						}
					}
					
					cartList.remove(chosenBookCase2);
					
					for(Book book : cartList) {
						displayCart(book, cartList);
					}
					System.out.println("Cart has been updated!");
					System.out.println();
					
				}
				
				
				break;
			case 3:
				System.out.println("-------------------------------------------");
				System.out.println("---------------- Register -----------------");
				System.out.println("-------------------------------------------");
				for(Book book : cartList) {
					displayCart(book, cartList);
					amount += book.getPrice();
				}
				System.out.println("You're total amount is: " + amount + " SEK");
				System.out.println();
				
				System.out.println("Would you like to proceed with your order?");
				System.out.println("(Enter 1 for yes and 2 for no)");

				int finishOrder = sc.nextInt();
				if(finishOrder != 2) {
					if(finishOrder != 1) {
						System.out.println("Please enter a valid choice for yes(1) or no(2)");
						finishOrder = sc.nextInt();
					}
				}
				
				if(finishOrder == 1) {
					Order order = new Order(true, cartList);
					System.out.println("-------------------------------------------");
					System.out.println("The total weight of your order is: " + order.getTotalWeight() + "g");
					System.out.println("The total price of your order is: " + order.getTotalPrice() + " SEK");
					System.out.println("Shipping will cost: " + order.gettotalShippingFee() + " SEK");
					System.out.println();
					System.out.println("Total price will be: "+ ( order.getTotalPrice() + order.gettotalShippingFee()) + " SEK");
					System.out.println();
					System.out.println("would you like your order shipped or picked up at store?");
					System.out.println("(Enter 1 for shipped and 2 for pick up)");
										
					
					System.out.println();
					
					int pickUp = sc.nextInt();
					if(pickUp != 2) {
						if(pickUp != 1) {
							System.out.println("Please enter a valid choice for yes(1) or no(2)");
							pickUp = sc.nextInt();
						}
					}
					
					if(pickUp == 1) {
						double totalPrice = order.getTotalPrice() + order.gettotalShippingFee();
						System.out.println("Total price including shipping: " + totalPrice + " SEK");
						System.out.println();
						System.out.println("Thank you for your purchase!");
						
						order.printReceipt();
						
						System.exit(0);
					} else {
						System.out.println("Thank you for your purchase!");
						
						order.printReceipt();
						
						System.exit(0);
					}

				}
				
				break;
			case 4:
				quit = true;
				break;
			default:
				System.out.println("Invalid entry..");
			}
		} while (!quit);

	}
	
	private static void displayMenu() {
		System.out.println("----------------- Welcome to the BookStore ------------------");
		System.out.println("1. Choose a book");
		System.out.println("2. Cart");
		System.out.println("3. Pay");
		System.out.println("4. Exit");
		System.out.println("-------------------------------------------------------------");
	}
	
	private static void displayLibrary(Book book, ArrayList<Book> list) {
		System.out.println("-------------------------------------------");
		System.out.println(list.indexOf(book) + 1 + ")");;
		System.out.println("Book title: " + book.getTitle());
		System.out.println("Book author: " + book.getAuthor());
		System.out.println("Book isbn: " + book.getIsbn());
		System.out.println("Book weight: " + book.getWeight() + "g");
		System.out.println("Book price: " + book.getPrice() + " SEK");
		System.out.println("-------------------------------------------");
	}
	
	private static void displayCart(Book book, ArrayList<Book> list) {
		System.out.println("-------------------------------------------");
		System.out.println(list.indexOf(book) + 1 + ")");
		System.out.println("Book title: " + book.getTitle());
		System.out.println("Book author: " + book.getAuthor());
		System.out.println("Book price: " + book.getPrice() + " SEK");
		System.out.println("-------------------------------------------");
	}
}
