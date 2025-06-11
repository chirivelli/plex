package net.sathwik.plex.services.impl;

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
}
