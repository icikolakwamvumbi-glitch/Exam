package app;

public class Product implements IProduct {
    private final String[] products;
    private final int[][] sales;
    public Product(String[] products, int [][] sales) {
        this.products = products;
        this.sales = sales;
}
  private int productTotal(int p) {
        int sum=0;
        for (int m = 0; m < sales[p].length; m++) sum += sales[p][m];
        return sum;
}
    private int countEntries(){
        int count = 0;
        for(int[] row : sales) count += row.length;
        return count;
}

    @Override
    public int GetTotalProductSold() {
        return 0;
    }

    @Override
public int GetTotalProductsSold() {
        int total = 0;
        for (int p = 0; p < sales.length; p++) total += productTotal(p);
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int entries = countEntries();
        if (entries == 0) return 0;
        return (double) GetTotalProductsSold() / entries;
    }

    @Override
    public String GetMostPopularProduct() {
        int best = 0;
        for (int p = 1; p < sales.length; p++) {
            if (productTotal(p) > productTotal(best)) best = p;
        }
        return products[best];
    }
}