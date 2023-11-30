package com.tomslabs.exercises.chapter4;

public class Exercise6 {
    private static class Item {
        private String desc;
        private double price;

        public Item(String desc, double price) {
            this.desc = desc;
            this.price = price;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Item otherItem) {
                return (desc != null && desc.equals(otherItem.desc)) &&
                        price == otherItem.price;
            } else {
                return false;
            }
        }
    }

    private static class DiscountedItem extends Item {
        double discount;

        public DiscountedItem(String desc, double price, double discount) {
            super(desc, price);
            this.discount = discount;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof DiscountedItem discountedItem) {
                return super.equals(obj) && discount == discountedItem.discount;
            } else if (obj instanceof Item) {
                return super.equals(obj);
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Item zonk = new Item("zonk", 1.0);
        DiscountedItem discountedZonk = new DiscountedItem("zonk", 1.0, 0.2);
        DiscountedItem moreDiscountedZonk = new DiscountedItem("zonk", 1.0, 0.3);
        System.out.println("Symmetry: " + zonk.equals(discountedZonk) + " " + discountedZonk.equals(zonk));
        System.out.println("Transitive: " + discountedZonk.equals(zonk) + " " + zonk.equals(moreDiscountedZonk) + " " + discountedZonk.equals(moreDiscountedZonk));
    }
}
