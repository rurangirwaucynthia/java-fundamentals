import java.util.Scanner;

public class CartMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();
        boolean running = true;

        while (running) {
            System.out.println("\n1) Add item  2) Remove item  3) Show item count  4) Empty cart  5) Exit");
            System.out.print("Choose: ");
            int choice = input.nextInt();
            input.nextLine();   // clear the leftover Enter key

            if (choice == 1 || choice == 2) {
                System.out.print("Item name: ");
                String name = input.nextLine();
                System.out.print("Quantity: ");
                int quantity = input.nextInt();
                System.out.print("Price per item: ");
                double price = input.nextDouble();
                input.nextLine();

                for (int i = 0; i < quantity; i++) {
                    if (choice == 1) {
                        cart.addItem(price);
                    } else {
                        cart.removeItem(price);
                    }
                }
            } else if (choice == 3) {
                System.out.println("Products in cart: " + cart.getTotalItems());
            } else if (choice == 4) {
                cart.emptyCart();
                System.out.println("Cart emptied.");
            } else if (choice == 5) {
                running = false;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        input.close();
    }
}

