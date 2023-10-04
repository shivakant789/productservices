package com.scaler.productservice.Controller;

import com.scaler.productservice.dtos.ErrorResponseDto;
import com.scaler.productservice.dtos.GetSingleProductResponseDto;
import com.scaler.productservice.dtos.ProductDto;
import com.scaler.productservice.dtos.ProductResponseDto;
import com.scaler.productservice.exceptions.NotFoundException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.service.FakeStoreProductService;
import com.scaler.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController{


    private ProductService productService;

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();

    }


    @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId) throws NotFoundException
    {
        //return productService.getSingleProduct(productId);
        //return "Returning single product with id "+productId;

        MultiValueMap<String,String> headers=new LinkedMultiValueMap<>();

        headers.add(
                "auth_token","noaccessfor4youheyhey"
        );
        Optional<Product> productOptional = productService.getSingleProduct(productId);

        if (productOptional.isEmpty()) {
            throw new NotFoundException("No Product with product id: " + productId);
        }
        ResponseEntity<Product> response=new ResponseEntity(
                productService.getSingleProduct(productId),
                headers,
                HttpStatus.OK
        );
       // GetSingleProductResponseDto responseDto= new GetSingleProductResponseDto();
        // responseDto.setProduct(productService.getSingleProduct(productId));
        // return responseDto;
        return response;
    }

    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto){
        //return "Add new Product"+productDto;

        Product newproduct= productService.addNewProduct(productDto);

        ResponseEntity<Product> response= new ResponseEntity<>(newproduct,HttpStatus.OK);

        return  response;
    }


    @PatchMapping("/{productId}")
    public Product updateProduct(@PathVariable("productId") Long productId,@RequestBody ProductDto productDto){
        //return "Updating the Product"+productId;
        Product product= new Product();
        product.setId(productDto.getId());
        product.setCategory(new Category());
        product.getCategory().setName(productDto.getCategory());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDesciption(productDto.getDescription());

        return productService.updateProduct(productId,product);
    }


    @DeleteMapping("/{productId}")
    public Optional<Product> deleteProduct(@PathVariable("productId") Long productId,@RequestBody ProductDto productDto)throws NotFoundException{
       // return "Deleting the Product with id : "+productId;
        Optional<Product> productOptional = productService.deleteProduct(productId);

        if (productOptional.isEmpty()) {
            throw new NotFoundException("No Product with product id: " + productId);
        }
        return productService.deleteProduct(productId);
    }


   /* @ExceptionHandler(NotFoundException.class)
    public  ResponseEntity<ErrorResponseDto> nothandledException(Exception exception){
        ErrorResponseDto errorResponseDto= new ErrorResponseDto();
        errorResponseDto.setErrorMessage(exception.getMessage());

        return new ResponseEntity<>(errorResponseDto,HttpStatus.NOT_FOUND);

    }*/

}
