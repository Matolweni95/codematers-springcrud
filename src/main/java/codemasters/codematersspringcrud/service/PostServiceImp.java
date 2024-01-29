package codemasters.codematersspringcrud.service;

import codemasters.codematersspringcrud.entity.Post;
import codemasters.codematersspringcrud.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.time.Instant;

@Service
public class PostServiceImp implements PostService {
    private PostRepository postRepository;

    @Autowired
    public PostServiceImp(PostRepository thePostRepository) {
        postRepository = thePostRepository;
    }

    @Override
    public Long save(Post thePost) {
        Post post = new Post(
                thePost.getId(),
                thePost.getTitle(),
                thePost.getBody(),
                thePost.getPicture(),
                Instant.now());

        postRepository.save(post);

        return post.getId();
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public void deleteById(Long theId) {
        postRepository.deleteById(theId);

    }

    @Override
    public Optional<Post> findById(Long id) {
        Optional<Post> result = postRepository.findById(id);

        return Optional.empty();
    }

    @Override
    public boolean existsById(Long id) {
        return postRepository.existsById(id);
    }
}
