package net.sathwik.plex.controllers;

import lombok.RequiredArgsConstructor;
import net.sathwik.plex.domain.dtos.CategoryDto;
import net.sathwik.plex.domain.entities.CategoryEntity;
import net.sathwik.plex.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories() {
        List<CategoryEntity> categories = categoryService.listCategories();
        return null;
    }

}
