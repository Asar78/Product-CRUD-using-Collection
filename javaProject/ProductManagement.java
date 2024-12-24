package javaProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManagement {
	public static void main(String[] args) {
		ArrayList<Product> productList = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int choice;

		productList.add(new Product("p78", "smartphone", 25000, "Electronics"));
		productList.add(new Product("p56", "laptop", 70000, "Computers"));

		do {
			System.out.println("\n=== Product Management System ===");
			System.out.println("Type 1 to Add Product");
			System.out.println("Type 2 to Display Products");
			System.out.println("Type 3 to Search Product by ID");
			System.out.println("Type 4 to Remove Product by ID");
			System.out.println("Type 5 to Count Products");
			System.out.println("Type 6 to Search Products by Category");
			System.out.println("Type 7 to Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				// Adding a product
				System.out.print("Enter Product ID: ");
				String id = scanner.nextLine();
				System.out.print("Enter Product Name: ");
				String name = scanner.nextLine();
				System.out.print("Enter Product Price: ");
				double price = scanner.nextDouble();
				scanner.nextLine();
				System.out.print("Enter Product Category: ");
				String category = scanner.nextLine();

				productList.add(new Product(id, name, price, category));
				System.out.println("Product added successfully!\n");
				break;

			case 2:
				// Displaying all products
				if (productList.isEmpty()) {
					System.out.println("No products available.");
				} else {
					Collections.sort(productList);
					System.out.println("\n+----------------+--------------------+------------+------------------+");
					System.out.println("| Product ID     | Name               | Price      | Category         |");
					System.out.println("+----------------+--------------------+------------+------------------+");
					for (Product product : productList) {
						System.out.printf("| %-14s | %-18s | %-10.2f | %-16s |%n", product.getId(), product.getName(),
								product.getPrice(), product.getCategory());
					}
					System.out.println("+----------------+--------------------+------------+------------------+");
				}
				System.out.println();
				break;

			case 3:
				// Searching for a product by ID
				System.out.print("Enter Product ID to search: ");
				String searchId = scanner.nextLine();
				boolean found = false;
				for (Product product : productList) {
					if (product.getId().equalsIgnoreCase(searchId)) {
						System.out.println("Product found: " + product);
						found = true;
						System.out.println();
						break;
					}
				}
				if (!found) {
					System.out.println("Product with ID " + searchId + " not found.\n");
				}
				break;

			case 4:
				// Removing a product by ID
				System.out.print("Enter Product ID to remove: ");
				String removeId = scanner.nextLine();
				boolean removed = false;
				for (int i = 0; i < productList.size(); i++) {
					if (productList.get(i).getId().equalsIgnoreCase(removeId)) {
						productList.remove(i);
						System.out.println("Product with ID " + removeId + " removed successfully!\n");
						removed = true;
						break;
					}
				}
				if (!removed) {
					System.out.println("Product with ID " + removeId + " not found.\n");
				}
				break;

			case 5:
				// Displaying the count of products
				System.out.println("Total number of products: " + productList.size() + "\n");
				break;

			case 6:
				// Searching products by category
				System.out.print("Enter Product Category to search: ");
				String searchCategory = scanner.nextLine();
				boolean categoryFound = false;
				System.out.println("\nProducts in category: " + searchCategory);
				System.out.println("\n+----------------+--------------------+------------+------------------+");
				System.out.println("| Product ID     | Name               | Price      | Category         |");
				System.out.println("+----------------+--------------------+------------+------------------+");
				for (Product product : productList) {
					if (product.getCategory().equalsIgnoreCase(searchCategory)) {
						System.out.printf("| %-14s | %-18s | %-10.2f | %-16s |%n", product.getId(), product.getName(),
								product.getPrice(), product.getCategory());
						categoryFound = true;
					}
				}
				if (!categoryFound) {
					System.out.println("No products found in category: " + searchCategory);
				}
				System.out.println("+----------------+--------------------+------------+------------------+");
				System.out.println();
				break;

			case 7:

				System.out.println("Exiting the system. Goodbye!\n");
				break;

			default:
				System.out.println("Invalid choice! Please try again.\n");
			}
		} while (choice != 7);

		scanner.close();
	}
}
