package br.com.blz.testjava.adapters.inbound.request;


import br.com.blz.testjava.application.core.domain.Warehouses;

import java.util.List;

public class InventoryRequest {

    private List<WarehousesRequest> warehouses;

    public List<WarehousesRequest> getWarehouses() {
        return warehouses;
    }

    public InventoryRequest(){

    }
    private InventoryRequest(InventoryRequestBuilder builder){
        this.warehouses = builder.warehouses;
    }

    public static class InventoryRequestBuilder {
        private List<WarehousesRequest> warehouses;

        public InventoryRequestBuilder setWarehouses(List<WarehousesRequest> warehouses){
            this.warehouses = warehouses;
            return this;
        }

        public InventoryRequest build(){
            return new InventoryRequest(this);
        }
    }
}
