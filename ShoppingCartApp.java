import java.util.Scanner;

public class ShoppingCartApp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
         ShoppingCart cart = new ShoppingCart();
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n===== SHOPPING CART MENU =====");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Show total products in cart");
            System.out.println("4. Empty cart");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = input.nextInt();
            input.nextLine(); 

            if (choice == 1 || choice == 2) {
                System.out.print("Enter item name: ");
                String name = input.nextLine();
                System.out.print("Enter quantity: ");
                int quantity = input.nextInt();
                System.out.print("Enter price of one item: ");
                double price = input.nextDouble();
                input.nextLine();

                
                for (int i = 0; i < quantity; i++) {
                    if (choice == 1) {
                        cart.addItem(price);
                    } else {
                        cart.removeItem(price);
                    }
                }
                System.out.println("Done with: " + name);

            } else if (choice == 3) {
                System.out.println("Products in cart: " + cart.getTotalItems());
                System.out.println("Total price: $" + cart.getTotalPrice());

            } else if (choice == 4) {
                cart.emptyCart();

            } else if (choice == 5) {
                System.out.println("Goodbye!");

            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        input.close();
    }
}