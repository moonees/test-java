package br.com.blz.testjava.application.ports.in;

import br.com.blz.testjava.adapters.inbound.request.ProductRequest;
import br.com.blz.testjava.application.core.domain.Product;
import br.com.blz.testjava.application.core.domain.dto.ProductDTO;
import org.springframework.stereotype.Service;

public interface ProductPort {

    void register(ProductRequest product);

    ProductDTO productBySku(int sku);

    void productUpdateBySku(int sku, Product product);
}
