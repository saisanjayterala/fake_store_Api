package dev.sanjay.services;

import dev.sanjay.dtos.FakeStoreProductDto;
import dev.sanjay.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    private final RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {
        try {
            FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("http://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
            return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch product", e);
        }
    }

    @Override
    public List<Product> getAllProducts() {
        try {
            FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("http://fakestoreapi.com/products", FakeStoreProductDto[].class);
            List<Product> products = new ArrayList<>();
            for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
                products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
            }
            return products;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch products", e);
        }
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        if (fakeStoreProductDto == null) {
            return null;                                                                                                                                                            
        }
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImage(fakeStoreProductDto.getImage());
        return product;
    }
}
