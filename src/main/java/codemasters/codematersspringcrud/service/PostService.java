package codemasters.codematersspringcrud.service;

import codemasters.codematersspringcrud.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    Long save(Post thePost);

    List<Post> findAll();

    void deleteById(Long theId);

    Optional<Post> findById(Long id);

    boolean existsById(Long id);
}
