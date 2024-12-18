import java.util.Scanner;

public class Driver {
    private final Scanner input;
    private Store store;

    public static void main(String[] args) {
        new Driver();
    }

    public Driver() {
        this.input = new Scanner(System.in);
        this.processOrder();
        this.runMenu();
    }

    private int mainMenu() {
        System.out.print("Application menu\n---------\n   1) List all products\n   2) List the products in the current line\n   3) The average price of the products\n   4) the most expensive and the cheapest product\n   5) List products that are higher than a given price\n   6) List products that are cheaper then a given price\n   7) List information about the chosen product\n   8) Re-add product\n   0) exist\n==>>");
        return this.input.nextInt();
    }

    private void runMenu() {
        for(int option = this.mainMenu(); option != 0; option = this.mainMenu()) {
            switch (option) {
                case 1 -> this.printProducts();
                case 2 -> this.printCurrentProducts();
                case 3 -> this.printAverageProductPrice();
                case 4 -> this.printCheapestAndMostExpensiveProduct();
                case 5 -> this.printProductsAboveAPrice();
                case 6 -> this.printProductsLessAPrice();
                case 7 -> this.printChosenProduct();
                case 8 -> this.processOrder();
                default -> System.out.println("Invalid option entered: " + option);
            }

            System.out.println("\nPress enter to continue...");
            this.input.nextLine();
            this.input.nextLine();
        }

        System.out.println("Existing...bye");
        System.exit(0);
    }

    private void processOrder() {
        System.out.print("How many products do you want to add to the store?  ");
        int numberProducts = this.input.nextInt();
        this.store = new Store(numberProducts);

        for(int i = 0; i < numberProducts; ++i) {
            this.addProduct();
        }

    }

    private void addProduct() {
        this.input.nextLine();
        System.out.print("Enter the name of the product:  ");
        String productName = this.input.nextLine();
        System.out.print("Enter the code of the product:  ");
        int productCode = this.input.nextInt();
        System.out.print("Enter the price of the product:  ");
        double unitCost = this.input.nextDouble();
        System.out.print("Whether the product is in the current line (y/n): ");
        char currentProduct = this.input.next().charAt(0);
        boolean inCurrentProductLine = currentProduct == 'y' || currentProduct == 'Y';
        boolean isAdded = this.store.add(new Product(productName, productCode, unitCost, inCurrentProductLine));
        if (isAdded) System.out.println("Product added successfully.");
        else System.out.println("No product added.");
    }
    private void printProducts() {
        System.out.println("The products listed are:");
        System.out.println(this.store.listProducts());
    }
    private void printChosenProduct(){
        System.out.println("Enter the index of the product:");
        int index = this.input.nextInt();
        System.out.println(this.store.listChosenProduct(index));
    }

    private void printCurrentProducts() {
        System.out.println("The products in the current line are:");
        System.out.println(this.store.listCurrentProducts());
    }

    private void printAverageProductPrice() {
        double averagePrice = this.store.averageProductPrice();
        if (averagePrice != -1.0) {
            System.out.println("The average price of the products is: " + averagePrice);
        } else {
            System.out.println("There is no products in the store.");
        }

    }

    private void printCheapestAndMostExpensiveProduct() {
        Product cheapestProduct = this.store.cheapestProduct();
        Product mostexpensiveProduct = this.store.MostExpensiveProduct();
        if (cheapestProduct != null) {
            System.out.println("The cheapest product is:  " + cheapestProduct.getProductName());
        } else {
            System.out.println("There is no cheapest product in the store.");
        }
        if (mostexpensiveProduct != null) {
            System.out.println("The most expensive product is: " + mostexpensiveProduct.getProductName());
        }else {
            System.out.println("There is no most expensive product in the store.");
        }
    }
    private void printProductsAboveAPrice() {
        System.out.print("The given price is:  ");
        double price = this.input.nextDouble();
        System.out.println(this.store.listProductsAboveAPrice(price));
    }
    private void printProductsLessAPrice() {
        System.out.print("The given price is:  ");
        double price = this.input.nextDouble();
        System.out.println(this.store.listProductsLessAPrice(price));
    }
}
