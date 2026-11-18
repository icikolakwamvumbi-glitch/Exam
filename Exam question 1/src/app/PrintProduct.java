package app;

public class PrintProduct {
    private final IProduct product;
    private final int year;

    public PrintProduct(IProduct product, int year) {
        this.product = product;
        this.year = year;
    }

    public void printTotalSales() {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    public void printAverageSales() {
        System.out.println("AVERAGE PRODUCT SALES: " + (int) product.GetAverageProductSold());
    }

    public void printMostPopular() {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }

    public void printReport() {
        System.out.println("\nPRODUCT SALES REPORT - " + year);
        System.out.println("*".repeat(40));
        printTotalSales();
        printAverageSales();
        printMostPopular();
    }
}

