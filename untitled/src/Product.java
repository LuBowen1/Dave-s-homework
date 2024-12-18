public class Product {
    private final String productName;
    private final int productCode;
    private final double unitCost;
    private final boolean inCurrentProductLine;

    public Product(String productName, int productCode, double unitCost, boolean inCurrentProductLine) {
        this.productName = productName;
        this.productCode = productCode;
        this.unitCost = unitCost;
        this.inCurrentProductLine = inCurrentProductLine;
    }

    public String getProductName() {
        return this.productName;
    }

    public double getUnitCost() {
        return this.unitCost;
    }

    public boolean isInCurrentProductLine() {
        return this.inCurrentProductLine;
    }

    public String toString() {
        return "Product description: " + this.productName + ", product code: " + this.productCode + ", unit cost: " + this.unitCost + ", currently in product line: " + this.inCurrentProductLine;
    }
}
