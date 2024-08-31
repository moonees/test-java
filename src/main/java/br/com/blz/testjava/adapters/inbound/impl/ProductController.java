package br.com.blz.testjava.adapters.inbound.impl;

import br.com.blz.testjava.adapters.inbound.IProductController;
import br.com.blz.testjava.adapters.inbound.request.ProductRequest;
import br.com.blz.testjava.application.core.domain.Product;
import br.com.blz.testjava.application.core.domain.dto.ProductDTO;
import br.com.blz.testjava.application.ports.in.ProductPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController implements IProductController {

    private final ProductPort productPort;

    @Autowired
    public ProductController(ProductPort productPort) {
        this.productPort = productPort;
    }

    @PostMapping("/register")
    @Override
    public ResponseEntity<String> productRegister(@RequestBody ProductRequest product){

        productPort.register(product);

        return ResponseEntity.status(HttpStatus.CREATED).body("Product registered successfully");

    }


    @GetMapping(value = "/sku")
    @Override
    public ResponseEntity<ProductDTO> productBySku(@RequestParam int sku){

        ProductDTO productDTO = productPort.productBySku(sku);

        return ResponseEntity.status(HttpStatus.OK).body(productDTO);

    }

    @PutMapping(value = "/sku/{sku}")
    @Override
    public ResponseEntity<String> productUpdateBySku(@PathVariable int sku, @RequestBody ProductRequest product){

        productPort.productUpdateBySku(sku, product);

        return ResponseEntity.status(HttpStatus.CREATED).body("Product updated successfully");

    }
}
