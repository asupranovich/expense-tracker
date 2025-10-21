package com.asupranovich.expense.tracker.web.controller;

import com.asupranovich.expense.tracker.domain.model.Category;
import com.asupranovich.expense.tracker.domain.service.CategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getDefaultCategories() {
        return ResponseEntity.ok(categoryService.getDefaultCategories());
    }
}
