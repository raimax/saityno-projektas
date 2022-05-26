package lt.viko.eif.api.mapstruct;

import lt.viko.eif.api.dtos.PostDto;
import lt.viko.eif.api.models.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    @Mapping(target = "image", ignore = true)
    Post map(PostDto postDto);
}
