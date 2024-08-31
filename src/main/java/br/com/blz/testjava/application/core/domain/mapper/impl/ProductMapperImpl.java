package br.com.blz.testjava.application.core.domain.mapper.impl;

import br.com.blz.testjava.adapters.inbound.request.ProductRequest;
import br.com.blz.testjava.application.core.domain.Product;
import br.com.blz.testjava.application.core.domain.dto.ProductDTO;
import br.com.blz.testjava.application.core.domain.mapper.InventoryMapper;
import br.com.blz.testjava.application.core.domain.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements ProductMapper {

    private final InventoryMapper inventoryMapper;

    @Autowired
    public ProductMapperImpl(InventoryMapper inventoryMapper) {
        this.inventoryMapper = inventoryMapper;
    }

    @Override
    public Product productRequestToProduct(ProductRequest request) {
        return new Product.ProductBuilder()
            .setSku(request.getSku())
            .setName(request.getName())
            .setInventory(inventoryMapper.inventoryRequestToInventory(request.getInventory()))
            .build();
    }

    @Override
    public ProductDTO productToProductDTO(Product request) {
        return new ProductDTO.ProductDTOBuilder()
            .setSku(request.getSku())
            .setName(request.getName())
            .setIsMarketable(Boolean.FALSE)
            .setInventory(inventoryMapper.inventoryToInventoryDTO(request.getInventory()))
            .build();
    }
}
