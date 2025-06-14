package net.sathwik.plex.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.sathwik.plex.domain.dtos.CategoryDto;
import net.sathwik.plex.domain.dtos.CreateCategoryReq;
import net.sathwik.plex.domain.entities.CategoryEntity;
import net.sathwik.plex.mappers.CategoryMapper;
import net.sathwik.plex.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories() {
        List<CategoryDto> categories = categoryService.listCategories()
                .stream().map(categoryMapper::toDto)
                .toList();
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CreateCategoryReq createCategoryReq) {
        CategoryEntity categoryToCreate = categoryMapper.toEntity(createCategoryReq);
        CategoryDto categoryDto = categoryMapper.toDto(categoryService.createCategory(categoryToCreate));
        return new ResponseEntity<>(categoryDto, HttpStatus.CREATED);
    }

}
