package br.com.blz.testjava.application.core.domain;

import java.util.List;

public class Inventory {

    private List<Warehouses> warehouses;

    public List<Warehouses> getWarehouses() {
        return warehouses;
    }

    public Inventory(){

    }
    private Inventory(InventoryBuilder builder){
        this.warehouses = builder.warehouses;
    }

    public static class InventoryBuilder {
        private List<Warehouses> warehouses;

        public InventoryBuilder setWarehouses(List<Warehouses> warehouses){
            this.warehouses = warehouses;
            return this;
        }

        public Inventory build(){
            return new Inventory(this);
        }
    }

}
