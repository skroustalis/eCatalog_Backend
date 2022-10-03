package com.juicyCore.eCatalog.services;

import com.juicyCore.eCatalog.dto.CategoryDTO;
import com.juicyCore.eCatalog.models.CategoryModel;
import com.juicyCore.eCatalog.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService (CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }

    public String addCategory (CategoryModel category){
        String response="";
        categoryRepository.save(category);
        response = "Category add successfully";
        return response;
    }

    public List<CategoryModel> getAllCategories(){
        return categoryRepository.findAll();
    }


    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

    public void deleteAllCategories(){
        categoryRepository.deleteAll();
    }

    public CategoryModel getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    public void UpdateCategory (CategoryDTO categoryDTO, Long categoryId){
        CategoryModel category = categoryRepository.findById(categoryId).orElse(null);
        category.setName(categoryDTO.getName());
        category.setType(categoryDTO.getType());
        categoryRepository.save(category);
    }
}
