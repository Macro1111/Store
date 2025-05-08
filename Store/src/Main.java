import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.print(
                    """
                            
                            Welcome to your store menu! Please choose an option:
                                
                                1. Add Product
                                2. List of Products
                                3. Sell Product
                            
                                0. Exit
                            
                            Choose an option:"""
                    );
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    if(price< 0){
                        System.out.println("The value is not valid");
                    }else{
                        inventory.addProduct(name, price);
                        System.out.println("Product created");
                    }
                }
                case 2 -> inventory.listProducts();
                case 3 -> {
                    System.out.print("Enter product name to sell: ");
                    String name = scanner.nextLine();
                    inventory.sellProduct(name);
                }
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
