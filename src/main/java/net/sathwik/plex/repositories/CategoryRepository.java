package net.sathwik.plex.repositories;

import net.sathwik.plex.domain.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, UUID> {

    @Query("SELECT c FROM category c LEFT JOIN FETCH c.posts")
    List<CategoryEntity> findAllWithPostCount();
}
