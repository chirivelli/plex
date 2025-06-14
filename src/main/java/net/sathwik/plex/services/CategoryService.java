package net.sathwik.plex.services;


import net.sathwik.plex.domain.entities.CategoryEntity;

import java.util.List;

public interface CategoryService {

    List<CategoryEntity> listCategories();

    CategoryEntity createCategory(CategoryEntity category);
}
