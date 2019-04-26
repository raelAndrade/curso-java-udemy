package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data: ");
		System.out.println("Name: ");
		String name = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.next();
		System.out.println("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.println("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.println("How many items to this order? ");
		int n = sc.nextInt();
		for(int i=0; i<=n; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.println("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.println("Product price: ");
			double productPrice = sc.nextDouble();
			
			Product product= new Product(productName, productPrice);
			
			System.out.println("Quantity: ");
			int quantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order);
		
		sc.close();
		
		
//		Locale.setDefault(Locale.US);
//		Scanner sc = new Scanner(System.in);
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		
//		List<Product> list = new ArrayList<>();
//		
//		System.out.print("Enter the number of products: ");
//		int n =  sc.nextInt();
//		
//		for(int i=1; i<=n; i++) {
//			System.out.println("Product #" + i + "data:");
//			System.out.println("Common, used or imported (c/u/i)? ");
//			char ch = sc.next().charAt(0);
//			System.out.println("Name: ");
//			sc.nextLine();
//			String name = sc.nextLine();
//			System.out.println("Price: ");
//			double price = sc.nextDouble();
//			if (ch == 'c') {
//				list.add(new Product(name, price));
//			}else if (ch == 'u'){
//				System.out.println("Manufacture date (DD/MM/YYYY): ");
//				Date date = sdf.parse(sc.next());
//				list.add(new UseProduct(name, price, date));
//			}else {
//				System.out.println("Customs fee: ");
//				double customsFee = sc.nextDouble();
//				list.add(new ImportedProduct(name, price, customsFee));
//			}
//		}
//		
//		System.out.println();
//		System.out.println("PRICE TAGS:");
//		for(Product prod : list) {
//			System.out.println(prod.priceTag());
//		}
//		
//		sc.close();
		
//		Locale.setDefault(Locale.US);
//		Scanner sc = new Scanner(System.in);
//		
//		List<Employee> list = new ArrayList<>();
//		
//		System.out.print("Enter the number of employee: ");
//		int n = sc.nextInt();
//		for(int i = 1; i <= n; i++) {
//			System.out.println("Employee #" + i + " data:");
//			System.out.println("Outsourced (y/n)? ");
//			char ch = sc.next().charAt(0);
//			System.out.println("Name: ");
//			sc.nextLine();
//			String name = sc.nextLine();
//			System.out.println("Hours: ");
//			int hours = sc.nextInt();
//			System.out.println("Value per hours: ");
//			double valuePerHours = sc.nextDouble();
//			if(ch == 'y') {
//				System.out.println("Additional charge:");
//				double additionalCharge = sc.nextDouble();
//				list.add(new OutsourcedEmployee(name, hours, valuePerHours, additionalCharge));
//			}else {
//				list.add(new Employee(name, hours, valuePerHours));
//			}
//		}
//		System.out.println();
//		System.out.println("PAYMENTS");
//		for(Employee emp : list) {
//			System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
//		}
//		
//		sc.close();
	}
}
