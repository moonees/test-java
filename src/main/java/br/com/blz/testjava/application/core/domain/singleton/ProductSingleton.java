package br.com.blz.testjava.application.core.domain.singleton;

import br.com.blz.testjava.application.core.domain.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductSingleton {

    private List<Product> product;

    private ProductSingleton() {
        product = new ArrayList<>();
    }

    private static final class InstanceHolder {
        static final ProductSingleton instance = new ProductSingleton();
    }

    public static ProductSingleton getInstance() {
        return InstanceHolder.instance;
    }

    public List<Product> getProduct() {
        return product;
    }
}
