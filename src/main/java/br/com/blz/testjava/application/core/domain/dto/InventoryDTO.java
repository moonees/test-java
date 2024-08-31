package br.com.blz.testjava.application.core.domain.dto;

import java.util.List;

public class InventoryDTO {

    private List<WarehousesDTO> warehouses;

    private int quantity;

    public List<WarehousesDTO> getWarehouses() {
        return warehouses;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    private InventoryDTO(InventoryDTOBuilder builder){
        this.warehouses = builder.warehouses;
        this.quantity = builder.quantity;
    }


    public static class InventoryDTOBuilder {
        private List<WarehousesDTO> warehouses;

        private int quantity;

        public InventoryDTOBuilder setWarehouses(List<WarehousesDTO> warehouses){
            this.warehouses = warehouses;
            return this;
        }

        public InventoryDTOBuilder setQuantity(int quantity){
            this.quantity = quantity;
            return this;
        }

        public InventoryDTO build(){
            return new InventoryDTO(this);
        }
    }

}
