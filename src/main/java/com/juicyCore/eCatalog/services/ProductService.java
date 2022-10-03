package com.juicyCore.eCatalog.services;

import com.juicyCore.eCatalog.dto.ProductDTO;
import com.juicyCore.eCatalog.models.ProductModel;
import com.juicyCore.eCatalog.repositories.CategoryRepository;
import com.juicyCore.eCatalog.repositories.ProductRepository;
import com.juicyCore.eCatalog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

        @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, UserRepository userRepository){
        this.productRepository=productRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    public String addProduct (ProductDTO product){
        String response="";
        ProductModel prod = new ProductModel();
        prod.setCost(product.getCost());
        prod.setQuantity(product.getQuantity());
        prod.setName(product.getName());
        prod.setCategory(categoryRepository.getById(product.getCategory()));
        productRepository.save(prod);
        response = "Product add successfully";
        return response;

    }

    public List<ProductModel> getAllProducts(){
        return productRepository.findAll();
    }

//    public Optional<ProductModel> getProductById(Long id){
//        return productRepository.findById(id);
//    }

    public ProductModel getProduct(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public void deleteAllProducts(){
        productRepository.deleteAll();
    }

    public void UpdateProduct(ProductDTO productDTO, Long productId){
        ProductModel product = productRepository.findById(productId).orElse(null);
        product.setCost(productDTO.getCost());
        product.setQuantity(productDTO.getQuantity());
        product.setName(productDTO.getName());
        product.setCategory(categoryRepository.findById(productDTO.getCategory()).orElse(null));
        productRepository.save(product);

    }

    public List<ProductModel> AllProductsByCat(Long productId){
            return productRepository.findAllProductsByCat(productId);
    }


}

