package br.com.blz.testjava.application.core.domain.dto;

public class WarehousesDTO {

    private String locality;

    private int quantity;

    private  String type;


    public String getLocality() {
        return locality;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }

    private WarehousesDTO(WarehousesDTOBuilder builder){
        this.locality = builder.locality;
        this.quantity = builder.quantity;
        this.type = builder.type;
    }

    public static class WarehousesDTOBuilder{
        private String locality;

        private int quantity;

        private  String type;

        public WarehousesDTOBuilder setLocality(String locality){
            this.locality = locality;
            return this;
        }

        public WarehousesDTOBuilder setQuantity(int quantity){
            this.quantity = quantity;
            return this;
        }

        public WarehousesDTOBuilder setType(String type){
            this.type = type;
            return this;
        }

        public WarehousesDTO build(){
            return new WarehousesDTO(this);
        }
    }
}
