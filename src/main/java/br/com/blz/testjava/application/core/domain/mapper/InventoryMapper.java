package br.com.blz.testjava.application.core.domain.mapper;

import br.com.blz.testjava.adapters.inbound.request.InventoryRequest;
import br.com.blz.testjava.adapters.inbound.request.ProductRequest;
import br.com.blz.testjava.application.core.domain.Inventory;
import br.com.blz.testjava.application.core.domain.Product;
import br.com.blz.testjava.application.core.domain.dto.InventoryDTO;
import br.com.blz.testjava.application.core.domain.dto.ProductDTO;

public interface InventoryMapper {

    public Inventory inventoryRequestToInventory(InventoryRequest request);

    public InventoryDTO inventoryToInventoryDTO(Inventory request);
}
