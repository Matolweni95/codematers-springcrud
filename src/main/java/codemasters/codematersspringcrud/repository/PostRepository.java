package codemasters.codematersspringcrud.repository;

import codemasters.codematersspringcrud.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
