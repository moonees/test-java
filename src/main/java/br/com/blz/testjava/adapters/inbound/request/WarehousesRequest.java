package br.com.blz.testjava.adapters.inbound.request;

import br.com.blz.testjava.application.core.domain.Warehouses;

public class WarehousesRequest {

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

    public WarehousesRequest(){

    }
    private WarehousesRequest(WarehousesRequestBuilder builder){
        this.locality = builder.locality;
        this.quantity = builder.quantity;
        this.type = builder.type;
    }

    public static class WarehousesRequestBuilder{
        private String locality;

        private int quantity;

        private  String type;

        public WarehousesRequestBuilder setLocality(String locality){
            this.locality = locality;
            return this;
        }

        public WarehousesRequestBuilder setQuantity(int quantity){
            this.quantity = quantity;
            return this;
        }

        public WarehousesRequestBuilder setType(String type){
            this.type = type;
            return this;
        }

        public WarehousesRequest build(){
            return new WarehousesRequest(this);
        }
    }
}
