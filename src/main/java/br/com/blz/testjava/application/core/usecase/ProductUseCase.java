package br.com.blz.testjava.application.core.usecase;

import br.com.blz.testjava.adapters.inbound.request.ProductRequest;
import br.com.blz.testjava.application.core.domain.Product;
import br.com.blz.testjava.application.core.domain.dto.ProductDTO;
import br.com.blz.testjava.application.core.domain.dto.WarehousesDTO;
import br.com.blz.testjava.application.core.domain.mapper.ProductMapper;
import br.com.blz.testjava.application.core.domain.singleton.ProductSingleton;
import br.com.blz.testjava.application.core.usecase.exception.ProductNotFoundException;
import br.com.blz.testjava.application.core.usecase.exception.SkuAlreadyRegisterException;
import br.com.blz.testjava.application.ports.in.ProductPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductUseCase implements ProductPort {

    private final ProductSingleton productSingleton = ProductSingleton.getInstance();

    private final ProductMapper productMapper;


    @Autowired
    public ProductUseCase(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public void register(ProductRequest product) {
        Optional<Product> result = productSingleton.getProduct().stream()
            .filter(sku -> sku.getSku() == product.getSku())
            .findFirst();

        if(result.isPresent()){
            throw new SkuAlreadyRegisterException(String.format("Sku %d already registered", product.getSku()));
        }

        productSingleton.getProduct().add(productMapper.productRequestToProduct(product));
    }

    @Override
    public ProductDTO productBySku(int sku) {
        try {
            Product result = productSingleton.getProduct().stream()
                .filter(product -> product.getSku() == sku)
                .findFirst().orElseThrow();

            ProductDTO response = productMapper.productToProductDTO(result);

            response.getInventory().setQuantity(totalQuantity(response));

            response.setIsMarketable(isMarketable(response.getInventory().getQuantity()));

            return response;
        }catch (RuntimeException e){
            throw new ProductNotFoundException(String.format("Product not found whit sku %d", sku));
        }
    }

    @Override
    public void productUpdateBySku(int sku, ProductRequest newProduct) {
        try {
            Product response = productSingleton.getProduct().stream()
                .filter(product -> product.getSku() == sku)
                .findFirst().orElseThrow();

            productSingleton.getProduct().remove(response);

            productSingleton.getProduct().add(productMapper.productRequestToProduct(newProduct));

        }catch (RuntimeException e){
            throw new ProductNotFoundException(String.format("Product not found whit sku %d", sku));
        }
    }

    public static int totalQuantity(ProductDTO productDTO){
        int quantity = 0;
        for(WarehousesDTO warehouses : productDTO.getInventory().getWarehouses()){
            quantity += warehouses.getQuantity();
        }
        return quantity;
    }

    public static Boolean isMarketable(int quantity){
        return (quantity > 0 ? Boolean.TRUE : Boolean.FALSE);
    }
}
