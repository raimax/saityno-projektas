package lt.viko.eif.api.service;

import lt.viko.eif.api.dtos.PostDto;
import lt.viko.eif.api.mapstruct.MapStructMapper;
import lt.viko.eif.api.models.Post;
import lt.viko.eif.api.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final AzureStorageService storageService;
    private final MapStructMapper mapper;
    private final ImageOptimizationService imageOptimizationService;

    @Autowired
    public PostServiceImpl(PostRepository postRepository,
                           AzureStorageService storageService,
                           MapStructMapper mapper,
                           ImageOptimizationService imageOptimizationService) {
        this.postRepository = postRepository;
        this.storageService = storageService;
        this.mapper = mapper;
        this.imageOptimizationService = imageOptimizationService;
    }

    @Override
    public Post getById(Integer id) throws NoSuchElementException {
        Post post = postRepository.findById(id).orElseThrow();
        post.setViews(post.getViews() + 1);
        return postRepository.save(post);
    }

    @Override
    @Cacheable(value = "posts")
    public List<Post> getAll() {
        return (List<Post>) postRepository.findAll();
    }

    @Override
    @CacheEvict(value = "posts", allEntries = true)
    public void add(PostDto postDto) throws IOException {
        Post post = mapper.map(postDto);
        String imageName = storageService.uploadFile(postDto.getImageFile(), AzureStorageService.Container.unoptimized);
        String newImageName = imageOptimizationService.optimizeImage(imageName);
        post.setImage(newImageName);
        post.getUser().setId(postDto.getUserId());
        postRepository.save(post);
    }

    @Override
    public Post getRandom() {
        Post randomPost = postRepository.getRandom();
        randomPost.setViews(randomPost.getViews() + 1);
        postRepository.save(randomPost);
        return randomPost;
    }

    @Override
    public List<Post> getTopByViews() {
        return postRepository.findTop3ByOrderByViewsDesc();
    }
}
