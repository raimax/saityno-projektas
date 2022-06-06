package lt.viko.eif.api.mapstruct;

import lt.viko.eif.api.dtos.CommentDto;
import lt.viko.eif.api.dtos.PostDto;
import lt.viko.eif.api.models.Comment;
import lt.viko.eif.api.models.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface MapStructMapper {
    @Mapping(target = "image", ignore = true)
    @Mapping(target = "user", ignore = true)
    Post map(PostDto postDto);
    Comment map(CommentDto commentDto);
}
