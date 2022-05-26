package lt.viko.eif.api.mapstruct;

import lt.viko.eif.api.dtos.LikeDto;
import lt.viko.eif.api.models.Like;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    Like map(LikeDto likeDto);
    LikeDto map(Like like);
}
