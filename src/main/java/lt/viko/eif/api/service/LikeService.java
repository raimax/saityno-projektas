package lt.viko.eif.api.service;

import lt.viko.eif.api.dtos.LikeDto;

public interface LikeService {
    void add(LikeDto likeDto);
    boolean userLikedAlready(Integer userId, Integer postId);
    void remove(LikeDto likeDto);
}
