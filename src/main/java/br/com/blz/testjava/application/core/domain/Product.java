package br.com.blz.testjava.application.core.domain;

public class Product {

    private int sku;

    private String name;

    private Inventory inventory;

    public Product(){

    }
    private Product(ProductBuilder builder){
        this.sku = builder.sku;
        this.name = builder.name;
        this.inventory = builder.inventory;
    }

    public int getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public static class ProductBuilder{
        private int sku;

        private String name;

        private Inventory inventory;



        public ProductBuilder setSku(int sku){
            this.sku = sku;
            return this;
        }

        public ProductBuilder setName(String name){
            this.name = name;
            return this;
        }

        public ProductBuilder setInventory(Inventory inventory){
            this.inventory = inventory;
            return this;
        }

        public Product build(){
            return new Product(this);
        }
    }

}
