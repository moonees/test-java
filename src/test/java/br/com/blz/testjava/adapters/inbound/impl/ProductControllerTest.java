package br.com.blz.testjava.adapters.inbound.impl;

import br.com.blz.testjava.adapters.inbound.request.ProductRequest;
import br.com.blz.testjava.application.core.domain.dto.ProductDTO;
import br.com.blz.testjava.application.ports.in.ProductPort;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductPort productPort;

    private Gson gson;

    @BeforeEach
    public void setUp() {
        gson = new Gson();
    }


    @Test
    void shouldRegisterProductWhenEndpointRegisterWasCalled() throws Exception {
        ProductRequest productRequest = Utils.productRequestGenerator();

        doNothing().when(productPort).register(productRequest);

        mockMvc.perform(post("/product/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(productRequest)))
            .andExpect(status().isCreated())
            .andExpect(content().string("Product registered successfully"));
    }

    @Test
    void shouldReturnProductWhenEndpointSkuWasCalled() throws Exception {
        ProductDTO productDTO = Utils.productDTOGenerator();

        when(productPort.productBySku(1234)).thenReturn(productDTO);

        mockMvc.perform(get("/product/sku")
                .contentType(MediaType.APPLICATION_JSON)
                .param("sku", "1234"))
            .andExpect(status().isOk())
            .andExpect(content().string(gson.toJson(productDTO)));
    }

    @Test
    void shouldUpdateProductWhenEndpointProductUpdateWasCalled() throws Exception {
        ProductRequest productRequest = Utils.productRequestGenerator();

        doNothing().when(productPort).productUpdateBySku(1234,productRequest);

        mockMvc.perform(put("/product/sku/1234")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(productRequest)))
            .andExpect(status().isCreated())
            .andExpect(content().string("Product updated successfully"));
    }
}
