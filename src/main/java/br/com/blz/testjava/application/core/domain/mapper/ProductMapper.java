package br.com.blz.testjava.application.core.domain.mapper;

import br.com.blz.testjava.adapters.inbound.request.ProductRequest;
import br.com.blz.testjava.application.core.domain.Product;
import br.com.blz.testjava.application.core.domain.dto.ProductDTO;

public interface ProductMapper {

    public Product productRequestToProduct(ProductRequest request);

    public ProductDTO productToProductDTO(Product request);
}
