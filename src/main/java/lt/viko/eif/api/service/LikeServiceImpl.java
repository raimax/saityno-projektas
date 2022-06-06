package lt.viko.eif.api.service;

import lt.viko.eif.api.dtos.LikeDto;
import lt.viko.eif.api.models.Like;
import lt.viko.eif.api.repositories.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

/**
 * This class manages likes
 */
@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    private LikesRepository likesRepository;

    /**
     * This method saves a like
     *
     * @param likeDto data transfer object of the like parameter
     */
    @Override
    @CacheEvict(value = "posts", allEntries = true)
    public void add(LikeDto likeDto) {
        Like like = new Like();
        like.getUser().setId(likeDto.getUserId());
        like.getPost().setId(likeDto.getPostId());
        likesRepository.save(like);
    }

    /**
     * This method checks if user already liked a post
     *
     * @param userId user ID
     * @param postId post ID
     * @return boolean
     */
    public boolean userLikedAlready(Integer userId, Integer postId) {
        Like like = likesRepository.findByUserIdAndPostId(userId, postId);
        return like != null;
    }

    /**
     * This method removes like
     *
     * @param likeDto data transfer object of the like parameter
     */
    @Override
    @CacheEvict(value = "posts", allEntries = true)
    public void remove(LikeDto likeDto) {
        Like like = new Like();
        like.getUser().setId(likeDto.getUserId());
        like.getPost().setId(likeDto.getPostId());
        Like usersLike = likesRepository.findByUserIdAndPostId(likeDto.getUserId(), likeDto.getPostId());
        likesRepository.delete(usersLike);
    }
}
