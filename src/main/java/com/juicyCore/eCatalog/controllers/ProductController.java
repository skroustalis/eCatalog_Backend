package com.juicyCore.eCatalog.controllers;

import com.juicyCore.eCatalog.dto.ProductDTO;
import com.juicyCore.eCatalog.models.ProductModel;
import com.juicyCore.eCatalog.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
        }

    @PostMapping(path ="/addProduct")
    public String addNew(@RequestBody ProductDTO product){
        return productService.addProduct(product);
    }


    @GetMapping(path = "/allProducts")
    public List<ProductModel> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping(path = "/Product/{id}")
    public ProductModel getProduct(@PathVariable(value = "id") Long productId) {
        return productService.getProduct(productId);
    }

    @DeleteMapping(path ="/deleteProduct/{id}")
    public String deleteById(@PathVariable ("id") Long productId){productService.deleteProduct(productId);
        return "Successfully deleted Product";
    }

    @DeleteMapping(path = "/deleteAllProducts")
    public void deleteAllProducts(){productService.deleteAllProducts();}

    @PutMapping (path = "/updateProduct/{id}")
    public ProductDTO updateProduct(@PathVariable(value ="id") Long productId,@RequestBody ProductDTO product){
        productService.UpdateProduct(product, productId);
        return product;
    }

    @GetMapping(path = "/allProductsByCat/{id}")
        public List<ProductModel> AllProductsByCat(@PathVariable(value = "id")Long productId){
         return productService.AllProductsByCat(productId);
    }

}
