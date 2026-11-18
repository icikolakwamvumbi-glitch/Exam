import app.PrintProduct;
import app.Product;

import java.util.Scanner;
  public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      String[] products = {"Cozy Nights Monarch mattress", "Restonic Barbados mattress", "Sealy Phuket mattress"};
      int months = 3;
      int[][] sales = new int[products.length][months];

      for (int p = 0; p < products.length; p++) {
          for (int m = 0; m < months; m++) {
              System.out.print("Enter number of sales for month" + (m + 1) + " for " + products[p] + ": ");
              sales[p][m] = in.nextInt();
          }
      }
      String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
      Product product = new Product(names, sales);
      new PrintProduct(product, 2026).printReport();
  }


