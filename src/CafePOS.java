package src.java_method;
public class CafePOS {

    
    public static double calculateTax(double amount, double taxRate) {
        double tax = amount * taxRate;
        return amount + tax;
    }

    
    public static void generateReceipt(String name, double finalAmount) {
        System.out.println("\n===============================");
        System.out.println("        CAFE POS RECEIPT       ");
        System.out.println("===============================");
        System.out.println("Customer : " + name);
        System.out.printf("Total    : $%.2f%n", finalAmount);
        System.out.println("===============================");
        System.out.println("   Thank you, come again!      ");
    }

    public static void main(String[] args) {
        
        String customerName = "Alex";
        double coffeePrice = 4.50;
        int quantity = 4;
        boolean hasLoyaltyCard = false;

        
        double baseTotal = coffeePrice * quantity;
        double taxAmount = baseTotal * 0.08;   // tax on the original total (for reference)
        System.out.println("Base total: $" + baseTotal);
        System.out.println("Tax on base total: $" + taxAmount);

        
        double discountedTotal = baseTotal;

        if (hasLoyaltyCard) {
            discountedTotal = baseTotal - 2.50;
            if (discountedTotal < 0) {   // safety: never go below zero
                discountedTotal = 0;
            }
        } else if (baseTotal > 15.00) {
            discountedTotal = baseTotal - (baseTotal * 0.10);
        }

        
        System.out.print("Brewing in ");
        for (int i = 3; i >= 1; i--) {
            System.out.print(i + "... ");
        }
        System.out.println("Coffee is ready!");

        
        
        double finalAmount = calculateTax(discountedTotal, 0.08);
        generateReceipt(customerName, finalAmount);
    }
}
