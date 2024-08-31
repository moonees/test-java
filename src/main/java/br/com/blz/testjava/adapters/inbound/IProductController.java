package br.com.blz.testjava.adapters.inbound;

import br.com.blz.testjava.adapters.inbound.request.ProductRequest;
import br.com.blz.testjava.application.core.domain.Product;
import br.com.blz.testjava.application.core.domain.dto.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface IProductController {


    ResponseEntity<String> productRegister(@RequestBody ProductRequest product);


    ResponseEntity<ProductDTO> productBySku(@RequestParam int sku);

    ResponseEntity<String> productUpdateBySku(@PathVariable int sku, @RequestBody ProductRequest product);
}
