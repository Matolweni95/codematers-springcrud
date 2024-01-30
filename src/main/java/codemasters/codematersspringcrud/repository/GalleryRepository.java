package codemasters.codematersspringcrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import codemasters.codematersspringcrud.entity.Gallery;

public interface GalleryRepository extends JpaRepository<Gallery, Integer> {
    List<Gallery> findByUserId(Integer userId);

    List<Gallery> findByEvent(String event);
}
