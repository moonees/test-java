package br.com.blz.testjava.adapters.inbound.request;

public class ProductRequest {

    private int sku;

    private String name;

    private InventoryRequest inventory;

    public void setName(String name) {
        this.name = name;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public ProductRequest(){

    }
    private ProductRequest(ProductRequestBuilder builder){
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

    public InventoryRequest getInventory() {
        return inventory;
    }

    public static class ProductRequestBuilder{
        private int sku;

        private String name;

        private InventoryRequest inventory;



        public ProductRequestBuilder setSku(int sku){
            this.sku = sku;
            return this;
        }

        public ProductRequestBuilder setName(String name){
            this.name = name;
            return this;
        }

        public ProductRequestBuilder setInventory(InventoryRequest inventory){
            this.inventory = inventory;
            return this;
        }

        public ProductRequest build(){
            return new ProductRequest(this);
        }
    }
}
