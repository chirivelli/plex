package net.sathwik.plex.mappers;

import net.sathwik.plex.domain.PostStatus;
import net.sathwik.plex.domain.dtos.CategoryDto;
import net.sathwik.plex.domain.dtos.CreateCategoryReq;
import net.sathwik.plex.domain.entities.CategoryEntity;
import net.sathwik.plex.domain.entities.PostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    CategoryDto toDto(CategoryEntity category);

    CategoryEntity toEntity(CreateCategoryReq createCategoryReq);

    @Named("calculatePostCount")
    default long calculatePostCount(List<PostEntity> posts) {
        if (posts == null) {
            return 0;
        }
        return posts.stream()
                .filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }
}
