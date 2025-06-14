package net.sathwik.plex.services.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.sathwik.plex.domain.entities.CategoryEntity;
import net.sathwik.plex.repositories.CategoryRepository;
import net.sathwik.plex.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> listCategories() {
        return categoryRepository.findAllWithPostCount();
    }

    @Override
    @Transactional
    public CategoryEntity createCategory(CategoryEntity category) {
        if (categoryRepository.existsByNameIgnoreCase(category.getName())) {
            throw new IllegalArgumentException("Category already exists");
        }
        ;
        return categoryRepository.save(category);
    }
}
