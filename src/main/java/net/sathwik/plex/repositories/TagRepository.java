package net.sathwik.plex.repositories;

import net.sathwik.plex.domain.entities.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, UUID> {
}
