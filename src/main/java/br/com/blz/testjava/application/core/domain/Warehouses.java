package br.com.blz.testjava.application.core.domain;

public class Warehouses {

    private String locality;

    private int quantity;

    private  String type;

    public Warehouses(){

    }
    public String getLocality() {
        return locality;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }

    private Warehouses(WarehousesBuilder builder){
        this.locality = builder.locality;
        this.quantity = builder.quantity;
        this.type = builder.type;
    }

    public static class WarehousesBuilder{
        private String locality;

        private int quantity;

        private  String type;

        public WarehousesBuilder setLocality(String locality){
            this.locality = locality;
            return this;
        }

        public WarehousesBuilder setQuantity(int quantity){
            this.quantity = quantity;
            return this;
        }

        public WarehousesBuilder setType(String type){
            this.type = type;
            return this;
        }

        public Warehouses build(){
            return new Warehouses(this);
        }
    }

}
