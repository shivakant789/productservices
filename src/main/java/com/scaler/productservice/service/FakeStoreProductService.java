package com.scaler.productservice.service;

import com.scaler.productservice.clients.fakestoreapi.FakeStoreClient;
import com.scaler.productservice.clients.fakestoreapi.FakeStoreProductDto;
import com.scaler.productservice.dtos.ProductDto;
import com.scaler.productservice.exceptions.NotFoundException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;

    private FakeStoreClient fakeStoreClient;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder,FakeStoreClient fakeStoreClient){
        this.restTemplateBuilder=restTemplateBuilder;
        this.fakeStoreClient=fakeStoreClient;
    }

    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod,String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate= restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();

        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return (ResponseEntity)restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }
    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setImageUrl(productDto.getImage());

        return product;
    }
    @Override
    public List<Product> getAllProducts() {
       List<FakeStoreProductDto> fakeStoreProductDtos= fakeStoreClient.getAllProducts();

        List<Product> answer= new ArrayList<>();

        for (FakeStoreProductDto productDto:fakeStoreProductDtos) {

            answer.add(convertFakeStoreProductDtoToProduct(productDto));
        }
        return answer;
    }

    @Override
    public Optional<Product> getSingleProduct(Long productId) throws NotFoundException {
        FakeStoreProductDto fakeStoreProductDto=fakeStoreClient.getSingleProduct(productId);

       if(fakeStoreProductDto==null){
           return  Optional.empty();
       }

        return Optional.of(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
    }

    @Override
    public Product addNewProduct(ProductDto product) {
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                product,
                FakeStoreProductDto.class

        );

        FakeStoreProductDto productDto = response.getBody();


        return  convertFakeStoreProductDtoToProduct(productDto);


    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        FakeStoreProductDto fakeStoreProductDto=fakeStoreClient.updateProduct(productId,product);


        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Optional<Product> deleteProduct(Long productId) throws NotFoundException{
        FakeStoreProductDto fakeStoreProductDto= fakeStoreClient.deleteProduct(productId);

        if(fakeStoreProductDto==null){
            return Optional.empty();
        }


        return  Optional.of(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));



    }
}















/* private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    @Override
    public ProductResponseDto[] getAllProducts() {
        return restTemplate.getForObject("https://fakestoreapi.com/products",ProductResponseDto[].class);
    }

    @Override
    public String getSingleProduct(Long productId) {
        return restTemplate.getForObject("https://fakestoreapi.com/products/"+productId,String.class);
    }

    @Override
    public String addNewProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public String updateProduct(Long productId) {
        return null;
    }

    @Override
    public String deleteProduct(Long productId) {
        return null;
    }

    */