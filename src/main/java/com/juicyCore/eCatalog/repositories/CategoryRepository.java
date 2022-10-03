package com.juicyCore.eCatalog.repositories;

import com.juicyCore.eCatalog.models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<CategoryModel,Long> {
}
