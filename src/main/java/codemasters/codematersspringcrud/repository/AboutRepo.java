package codemasters.codematersspringcrud.repository;

import codemasters.codematersspringcrud.entity.About;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepo extends CrudRepository<About,Integer> {
}
