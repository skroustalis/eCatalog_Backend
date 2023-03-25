package com.juicyCore.eCatalog.repositories;


import com.juicyCore.eCatalog.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<ProductModel,Long> {

/** GET ALL PRODUCTS BY CATEGORY */
 @Query(value="SELECT * FROM products p WHERE p.category_id= :categoryId", nativeQuery = true)
    List<ProductModel> findAllProductsByCat(@Param("categoryId")Long productId);
}
