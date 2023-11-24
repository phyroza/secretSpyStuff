package com.tomslabs.exercises.chapter2;

import java.util.ArrayList;
import java.util.List;

public class Exercise16 {
    private static class Invoice {

        private List<Item> items = new ArrayList<>();

        public void addItem(String description, int quantity, double unitPrice) {
            Item item = new Item(description, quantity, unitPrice);
            items.add(item);
        }

        public void addItem(Item item) {
            items.add(item);
        }

        public void printInvoice() {
            System.out.println(items);
        }

        private static class Item {
            String description;
            int quantity;

            public Item(String description, int quantity, double unitPrice) {
                this.description = description;
                this.quantity = quantity;
                this.unitPrice = unitPrice;
            }

            double unitPrice;

            double price() {
                return quantity * unitPrice;
            }

            @Override
            public String toString() {
                return String.format("Item: %s, quantity: %d, unit price: %.2f", description, quantity, unitPrice);
            }
        }
    }

    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        invoice.addItem("Plates", 30, 7.75);
        invoice.addItem(new Invoice.Item("Forks", 30, 2.50));
        invoice.addItem(new Invoice.Item("Spoons", 30, 3.0));
        invoice.addItem(new Invoice.Item("Cups", 30, 6.0));
        invoice.addItem(new Invoice.Item("Cups", 30, 6.0));
        invoice.printInvoice();
    }
}
