package br.com.blz.testjava.application.core.domain.mapper.impl;

import br.com.blz.testjava.adapters.inbound.request.InventoryRequest;
import br.com.blz.testjava.application.core.domain.Inventory;
import br.com.blz.testjava.application.core.domain.dto.InventoryDTO;
import br.com.blz.testjava.application.core.domain.mapper.InventoryMapper;
import br.com.blz.testjava.application.core.domain.mapper.WarehousesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryMapperImpl implements InventoryMapper {

    private final WarehousesMapper warehousesMapper;

    @Autowired
    public InventoryMapperImpl(WarehousesMapper warehousesMapper) {
        this.warehousesMapper = warehousesMapper;
    }

    @Override
    public Inventory inventoryRequestToInventory(InventoryRequest request) {
        return new Inventory.InventoryBuilder()
            .setWarehouses(warehousesMapper.warehousesRequestToWarehouse(request.getWarehouses()))
            .build();
    }

    @Override
    public InventoryDTO inventoryToInventoryDTO(Inventory request) {
        return new InventoryDTO.InventoryDTOBuilder()
            .setWarehouses(warehousesMapper.warehousesToWarehousesDTO(request.getWarehouses()))
            .setQuantity(0)
            .build();
    }
}
