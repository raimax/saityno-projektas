package lt.viko.eif.api.service;

import lt.viko.eif.api.dtos.LikeDto;
import lt.viko.eif.api.models.Like;
import lt.viko.eif.api.repositories.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    private LikesRepository likesRepository;

    @Override
    public void add(LikeDto likeDto) {
        Like like = new Like();
        like.getUser().setId(likeDto.getUserId());
        like.getPost().setId(likeDto.getPostId());
        likesRepository.save(like);
    }

    public boolean userLikedAlready(Integer userId, Integer postId) {
        Like like = likesRepository.findByUserIdAndPostId(userId, postId);
        return like != null;
    }

    @Override
    public void remove(LikeDto likeDto) {
        Like like = new Like();
        like.getUser().setId(likeDto.getUserId());
        like.getPost().setId(likeDto.getPostId());
        Like usersLike = likesRepository.findByUserIdAndPostId(likeDto.getUserId(), likeDto.getPostId());
        likesRepository.delete(usersLike);
    }
}
