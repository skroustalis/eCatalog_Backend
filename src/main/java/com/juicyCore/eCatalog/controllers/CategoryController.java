package com.juicyCore.eCatalog.controllers;

import com.juicyCore.eCatalog.dto.CategoryDTO;
import com.juicyCore.eCatalog.models.CategoryModel;
import com.juicyCore.eCatalog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(path ="/addCategory")
    public String addNew(@RequestBody CategoryModel category){
        return categoryService.addCategory(category);
    }

    @GetMapping(path = "/allCategories")
    public List<CategoryModel> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping(path = "/Category/{id}")
    public CategoryModel getCategory(@PathVariable("id") Long id){
        return  categoryService.getCategory(id);
    }

    @DeleteMapping(path = "/deleteCategory/{id}")
    public void deleteCategory(@PathVariable(value = "id") Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }
    @DeleteMapping(path = "/deleteAllCategories")
    public void deleteAllCategories(){categoryService.deleteAllCategories();}

    @PutMapping(path = "/updateCategory/{id}")
    public CategoryDTO updateProduct(@PathVariable(value ="id") Long categoryId, @RequestBody CategoryDTO category) {
        categoryService.UpdateCategory(category, categoryId);
        return category;
    }
}
