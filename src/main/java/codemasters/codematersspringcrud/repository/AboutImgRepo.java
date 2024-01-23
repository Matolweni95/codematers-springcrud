package codemasters.codematersspringcrud.repository;

import codemasters.codematersspringcrud.entity.AboutImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutImgRepo extends CrudRepository<AboutImage,Integer> {

}
