package codemasters.codematersspringcrud.service;

import codemasters.codematersspringcrud.entity.About;
import codemasters.codematersspringcrud.repository.AboutRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class AboutService {
    private AboutRepo repo;

    @Autowired
    public AboutService(AboutRepo repo) {
        this.repo = repo;
    }

    public About saveAbout(About about){

        about.setDate(Instant.now());


        return repo.save(about);

    }

    public List<About> getAboutAll(){

        return (List<About>) repo.findAll();
    }


    public Optional<About> findById(int id) {
        return repo.findById(id);

    }

    public About getAbout(Integer id){

        Optional<About> About = repo.findById(id);

        if(About.isPresent()){
            return About.get();
        }

        return new About();


    }
}
