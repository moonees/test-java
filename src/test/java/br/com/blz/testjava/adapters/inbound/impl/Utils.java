package br.com.blz.testjava.adapters.inbound.impl;

import br.com.blz.testjava.adapters.inbound.request.InventoryRequest;
import br.com.blz.testjava.adapters.inbound.request.ProductRequest;
import br.com.blz.testjava.adapters.inbound.request.WarehousesRequest;
import br.com.blz.testjava.application.core.domain.Inventory;
import br.com.blz.testjava.application.core.domain.Product;
import br.com.blz.testjava.application.core.domain.Warehouses;
import br.com.blz.testjava.application.core.domain.dto.InventoryDTO;
import br.com.blz.testjava.application.core.domain.dto.ProductDTO;
import br.com.blz.testjava.application.core.domain.dto.WarehousesDTO;

import java.util.Collections;

public class Utils {

    public static Product productGenerator(){

        return new Product.ProductBuilder()
            .setName("Sabonete liquido melancia")
            .setInventory(inventoryGenerator())
            .setSku(1234)
            .build();
    }

    public static ProductRequest productRequestGenerator(){

        return new ProductRequest.ProductRequestBuilder()
            .setName("Sabonete liquido melancia")
            .setInventory(inventoryRequestGenerator())
            .setSku(1234)
            .build();
    }

    public static ProductDTO productDTOGenerator(){

        return new ProductDTO.ProductDTOBuilder()
            .setName("Sabonete liquido melancia")
            .setInventory(inventoryDTOGenerator())
            .setSku(1234)
            .setIsMarketable(true)
            .build();
    }

    public static Inventory inventoryGenerator(){

        return new Inventory.InventoryBuilder()
            .setWarehouses(Collections.singletonList(warehousesGenerator()))
            .build();
    }
    public static InventoryRequest inventoryRequestGenerator(){

        return new InventoryRequest.InventoryRequestBuilder()
            .setWarehouses(Collections.singletonList(warehousesRequestGenerator()))
            .build();
    }

    public static InventoryDTO inventoryDTOGenerator(){

        return new InventoryDTO.InventoryDTOBuilder()
            .setWarehouses(Collections.singletonList(warehousesDTOGenerator()))
            .build();
    }

    public static Warehouses warehousesGenerator(){

        return new Warehouses.WarehousesBuilder()
            .setLocality("Sao Paulo")
            .setType("ECOMMECER")
            .setQuantity(2)
            .build();
    }

    public static WarehousesDTO warehousesDTOGenerator(){

        return new WarehousesDTO.WarehousesDTOBuilder()
            .setLocality("Sao Paulo")
            .setType("ECOMMECER")
            .setQuantity(2)
            .build();
    }
    public static WarehousesRequest warehousesRequestGenerator(){

        return new WarehousesRequest.WarehousesRequestBuilder()
            .setLocality("Sao Paulo")
            .setType("ECOMMECER")
            .setQuantity(2)
            .build();
    }


}
