package app;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductApp extends JFrame {
    private final JTextField txtName = new JTextField(15);
    private final JComboBox<String> cmbProduct = new JComboBox<>(
            new String[]{"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"});
    private final JTextField txtPrice = new JTextField(15);
    private final JButton btnProcess = new JButton("PROCESS");

    public ProductApp() {
        super("Product App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 5, 10));

        add(new JLabel("Customer Name:"));  add(txtName);
        add(new JLabel("Select Product:")); add(cmbProduct);
        add(new JLabel("Enter Price:"));    add(txtPrice);
        add(new JLabel(""));                add(btnProcess);

        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenuItem miProcess = new JMenuItem("Process");
        JMenuItem miClear = new JMenuItem("Clear");
        JMenuItem miExit = new JMenuItem("Exit");
        file.add(miExit);
        edit.add(miProcess);
        edit.add(miClear);
        bar.add(file);
        bar.add(edit);
        setJMenuBar(bar);

        btnProcess.addActionListener(e -> process());
        miProcess.addActionListener(e -> process());   // same logic as the button
        miClear.addActionListener(e -> clear());
        miExit.addActionListener(e -> dispose());

        setSize(420, 220);
        setLocationRelativeTo(null);
    }

    private void process() {
        String name = txtName.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the customer name.");
            return;
        }
        double price;
        try {
            price = Double.parseDouble(txtPrice.getText().trim());
            if (price < 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price.");
            return;
        }

        String product = (String) cmbProduct.getSelectedItem();
        ProductCalculations calc = new ProductCalculations(price);
        double vat = calc.GetVat();
        double commission = calc.GetCommission();
        double total = calc.GetTotal();

        JOptionPane.showMessageDialog(this,
                "Customer Name: " + name + "\n" +
                        "Product: " + product + "\n" +
                        "VAT: R " + vat + "\n" +
                        "COMMISSION: R " + commission + "\n" +
                        "TOTAL: R " + total);

        try (PrintWriter out = new PrintWriter(new FileWriter("data.txt", true))) {
            out.println("DATA LOG");
            out.println("*".repeat(40));
            out.println("Customer Name: " + name);
            out.println("Product: " + product);
            out.println("VAT: R " + vat);
            out.println("COMMISSION: R " + commission);
            out.println("TOTAL: R " + total);
            out.println("*".repeat(40));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not write to data.txt: " + ex.getMessage());
        }
    }

    private void clear() {
        txtName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductApp().setVisible(true));
    }
}
