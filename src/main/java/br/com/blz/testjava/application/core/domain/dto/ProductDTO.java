package br.com.blz.testjava.application.core.domain.dto;

public class ProductDTO {

    private int sku;

    private String name;

    private InventoryDTO inventory;

    private Boolean isMarketable;

    public ProductDTO(){

    }

    public void setIsMarketable(Boolean marketable) {
        isMarketable = marketable;
    }

    public int getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public InventoryDTO getInventory() {
        return inventory;
    }

    public Boolean getIsMarketable() {
        return isMarketable;
    }

    private ProductDTO(ProductDTOBuilder builder){
        this.sku = builder.sku;
        this.name = builder.name;
        this.inventory = builder.inventory;
        this.isMarketable = builder.isMarketable;
    }

    public static class ProductDTOBuilder{
        private int sku;

        private String name;

        private InventoryDTO inventory;

        private Boolean isMarketable;


        public ProductDTOBuilder setSku(int sku){
            this.sku = sku;
            return this;
        }

        public ProductDTOBuilder setName(String name){
            this.name = name;
            return this;
        }

        public ProductDTOBuilder setInventory(InventoryDTO inventory){
            this.inventory = inventory;
            return this;
        }

        public ProductDTOBuilder setIsMarketable(Boolean isMarketable){
            this.isMarketable = isMarketable;
            return this;
        }

        public ProductDTO build(){
            return new ProductDTO(this);
        }
    }


}
