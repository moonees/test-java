package br.com.blz.testjava.application.core.usecase;

import br.com.blz.testjava.adapters.inbound.impl.Utils;
import br.com.blz.testjava.adapters.inbound.request.ProductRequest;
import br.com.blz.testjava.application.core.domain.Product;
import br.com.blz.testjava.application.core.domain.dto.ProductDTO;
import br.com.blz.testjava.application.core.domain.mapper.ProductMapper;
import br.com.blz.testjava.application.core.domain.singleton.ProductSingleton;
import br.com.blz.testjava.application.core.usecase.exception.ProductNotFoundException;
import br.com.blz.testjava.application.core.usecase.exception.SkuAlreadyRegisterException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductUseCaseTest {

    @InjectMocks
    private ProductUseCase useCase;

    @Mock
    private ProductMapper productMapper;


    @Test
    void shouldRegisterWithSuccessfully() {
        ProductRequest productRequest = Utils.productRequestGenerator();
        Product product = Utils.productGenerator();

        product.setSku(93812);

        productRequest.setSku(93812);

        when(productMapper.productRequestToProduct(productRequest)).thenReturn(product);

        useCase.register(productRequest);

        verify(productMapper, times(1)).productRequestToProduct(productRequest);
        assertFalse(ProductSingleton.getInstance().getProduct().isEmpty());

    }

    @Test
    void shouldThrowErrorWhenTryRegisterWithExistSku() {
        ProductRequest productRequest = Utils.productRequestGenerator();
        Product product = Utils.productGenerator();

        ProductSingleton.getInstance().getProduct().add(product);

        assertThrows(SkuAlreadyRegisterException.class, () -> {useCase.register(productRequest);
        });

    }

    @Test
    void shouldReturnProductWhenSkuWasPass() {
        ProductDTO productDTO = Utils.productDTOGenerator();
        Product product = Utils.productGenerator();

        ProductSingleton.getInstance().getProduct().add(product);

        when(productMapper.productToProductDTO(product)).thenReturn(productDTO);

        ProductDTO expected = useCase.productBySku(1234);

        verify(productMapper, times(1)).productToProductDTO(product);
        assertEquals(expected, productDTO);
    }


    @Test
    void shouldThrowErrorWhenSkuWasNotFound() {
        assertThrows(ProductNotFoundException.class, () -> {useCase.productBySku(1234);
        });
    }

    @Test
    void shouldUpdateProductWhenSkuWasPassWithNewBody() {
        ProductRequest productRequest = Utils.productRequestGenerator();
        Product product = Utils.productGenerator();

        ProductSingleton.getInstance().getProduct().add(product);

        product.setName("Shampoo");

        when(productMapper.productRequestToProduct(productRequest)).thenReturn(product);

        useCase.productUpdateBySku(1234, productRequest);

        verify(productMapper, times(1)).productRequestToProduct(productRequest);
        assertEquals("Shampoo", ProductSingleton.getInstance().getProduct().get(0).getName());
    }

    @Test
    void shouldThrowErrorWhenTryUpdateProduct() {
        ProductRequest productRequest = Utils.productRequestGenerator();

        assertThrows(ProductNotFoundException.class, () -> {useCase.productUpdateBySku(012312, productRequest);
        });

    }

    @Test
    void shouldCalculateHowManyItemsProductHave() {
        ProductDTO productDTO = Utils.productDTOGenerator();

        int expected = ProductUseCase.totalQuantity(productDTO);

        assertEquals(2, expected);

    }

    @Test
    void shouldBeIsMarketableTrue() {

        Boolean expected = ProductUseCase.isMarketable(1);

        assertEquals(Boolean.TRUE, expected);
    }

    @Test
    void shouldBeIsMarketableFalse() {

        Boolean expected = ProductUseCase.isMarketable(0);

        assertEquals(Boolean.FALSE, expected);
    }
}
