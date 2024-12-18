import java.io.Serializable;

public class Store {
    private final Product[] products;
    private int total = 0;

    public Store(int numberProducts) {
        this.products = new Product[numberProducts];
    }

    private boolean isFull() {
        return this.total == this.products.length;
    }

    private boolean isEmpty() {
        return this.total == 0;
    }

    public boolean add(Product product) {
        if (this.isFull()) {
            return false;
        } else {
            this.products[this.total++] = product;
            return true;
        }
    }

    public String listProducts() {
        if (this.isEmpty()) {
            return "There is no products in the store.";
        } else {
            StringBuilder listOfProducts = new StringBuilder();

            for (int i = 0; i < this.total; ++i) {
                listOfProducts.append(i).append(": ").append(this.products[i]).append("\n");
            }

            return listOfProducts.toString();
        }
    }

    public Product cheapestProduct() {
        if (!this.isEmpty()) {
            Product cheapestProduct = this.products[0];

            for (int i = 1; i < this.total; ++i) {
                if (this.products[i].getUnitCost() < cheapestProduct.getUnitCost()) {
                    cheapestProduct = this.products[i];
                }
            }

            return cheapestProduct;
        } else {
            return null;
        }
    }

    public Product MostExpensiveProduct() {
        if (!this.isEmpty()) {
            Product mostExpensiveProduct = this.products[0];
            for (int i = 1; i < this.total; ++i) {
                if (this.products[i].getUnitCost() > mostExpensiveProduct.getUnitCost()) {
                    mostExpensiveProduct = this.products[i];
                }
            }
            return mostExpensiveProduct;
        } else {
            return null;
        }
    }

    public String listCurrentProducts() {
        if (this.isEmpty()) {
            return "There is no products in the store.";
        } else {

            StringBuilder listOfProductsBuilder = new StringBuilder();
            for (int i = 0; i < this.total; ++i) {
                if (this.products[i].isInCurrentProductLine()) {
                    listOfProductsBuilder.append(i).append(": ").append(this.products[i]).append("\n");
                }
            }
            String listOfProducts = listOfProductsBuilder.toString();

            if (listOfProducts.isEmpty()) {
                return "There is no products in the current line";
            } else {
                return listOfProducts;
            }
        }
    }

    public double averageProductPrice() {
        if (this.isEmpty()) {
            return -1.0;
        } else {
            double totalPrice = 0.0;

            for (int i = 0; i < this.total; ++i) {
                totalPrice += this.products[i].getUnitCost();
            }

            return totalPrice / (double) this.products.length;
        }
    }

    public String listProductsAboveAPrice(double price) {
        if (this.isEmpty()) {
            return "There is no products in the store.";
        } else {

            StringBuilder strBuilder = new StringBuilder();
            for (int i = 0; i < this.total; ++i) {
                if (this.products[i].getUnitCost() > price) {
                    strBuilder.append(i).append(": ").append(this.products[i]).append("\n");
                }
            }
            String str = strBuilder.toString();

            if (str.isEmpty()) {
                return "There is no products higher than: " + price;
            } else {
                return str;
            }
        }
    }

    public String listProductsLessAPrice(double price) {
        if (this.isEmpty()) {
            return "There is no products in the store.";
        }else{
            StringBuilder strBuilder = new StringBuilder();
            for (int i = 0; i < this.total; ++i) {
                if (this.products[i].getUnitCost() < price) {
                    strBuilder.append(i).append(": ").append(this.products[i]).append("\n");
                }
            }
            String str = strBuilder.toString();

            if (str.isEmpty()) {
                return "There is no products cheaper than: " + price;
            }else{
                return str;
            }
        }
    }
    public Serializable listChosenProduct(int index) {
        StringBuilder listOfProducts;
        if (this.isEmpty()) {
            return "There is no products in the store.";
        }
        if(index-1>this.total){
            return "Can't find the product";
        }
        else {
            listOfProducts = new StringBuilder();
            listOfProducts.append(index-1).append(": ").append(this.products[index-1]).append("\n");
        }
        return listOfProducts;
    }
}

