package app;

import app.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {
    private final String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
    private final int[][] sales = {{25, 18, 20}, {15, 10, 12}, {18, 15, 20}};

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        Product p = new Product(names, sales);
        assertEquals(153, p.GetTotalProductsSold());
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        Product p = new Product(names, sales);
        assertEquals(17.0, p.GetAverageProductSold(), 0.001);
    }
}
