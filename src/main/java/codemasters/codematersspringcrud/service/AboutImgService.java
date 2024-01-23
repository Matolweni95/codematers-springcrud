package codemasters.codematersspringcrud.service;

import codemasters.codematersspringcrud.entity.AboutImage;
import codemasters.codematersspringcrud.repository.AboutImgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class AboutImgService {

    private AboutImgRepo aboutImgRepo;

    @Autowired
    public AboutImgService(AboutImgRepo aboutImgRepo) {
        this.aboutImgRepo = aboutImgRepo;
    }
    public AboutImage saveImageUrl(AboutImage aboutImage){

        aboutImage.setDate(Instant.now());

        return aboutImgRepo.save(aboutImage);
    }
    public Optional<AboutImage> findById(int id) {
        return aboutImgRepo.findById(id);

    }
    public List<AboutImage> getAllImage(){

        return (List<AboutImage>) aboutImgRepo.findAll();
    }
    public AboutImage getImage(Integer id){

        Optional<AboutImage> aboutImage = aboutImgRepo.findById(id);

        if(aboutImage.isPresent()){
            return aboutImage.get();
        }

        return new AboutImage();
    }
}
