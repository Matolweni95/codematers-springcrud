package codemasters.codematersspringcrud.controllers;

import codemasters.codematersspringcrud.entity.About;
import codemasters.codematersspringcrud.entity.AboutImage;
import codemasters.codematersspringcrud.service.AboutImgService;
import codemasters.codematersspringcrud.service.AboutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/about")
public class AboutController {
   private AboutService aboutService;
   private AboutImgService aboutImgService;

    public AboutController(AboutService aboutService, AboutImgService aboutImgService) {
        this.aboutService = aboutService;
        this.aboutImgService = aboutImgService;
    }



    @PostMapping("/saveAbout")
    public ResponseEntity<String> saveAbout(@RequestBody About about) {
        try {
            aboutService.saveAbout(about);
            return new ResponseEntity<>("About information saved successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to save About information", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAboutUs/{id}")
    public About getAbouts(@PathVariable Integer id){

        return aboutService.getAbout(id);
    }

    @GetMapping("/getAbout")
    @ResponseBody
    public List<About> getAbout(){
        return aboutService.getAboutAll();
    }

    @PutMapping("/aboutUpdate/{id}")
    public ResponseEntity<HttpStatus> updateAbout(@PathVariable Integer id, @RequestBody About about){

        About about1 = aboutService.getAbout(id);
        about1.setAbout_us(about.getAbout_us());
        about1.setVision(about.getVision());
        about1.setMission(about.getMission());
        about1.setAdmin_id(about.getAdmin_id());
        about1.setDate(about.getDate());

        aboutService.saveAbout(about1);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }


    @PostMapping("/saveImageUrl")
    public ResponseEntity<String> saveAboutImg(@RequestBody AboutImage aboutImage) {
        try {
            aboutImgService.saveImageUrl(aboutImage);
            return new ResponseEntity<>("Image url information saved successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to save About image url", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/getImage")
    @ResponseBody
    public List<AboutImage> getImages(){
        return aboutImgService.getAllImage();
    }

    @PutMapping("/updateImage/{user_id}")
    public ResponseEntity<HttpStatus> updateUrl(@RequestBody AboutImage aboutImage, @PathVariable int user_id){
        AboutImage image= aboutImgService.getImage(user_id);

        image.setImageUrl(aboutImage.getImageUrl());
        image.setCategory(aboutImage.getCategory());
        image.setAdmin_id(aboutImage.getAdmin_id());
        image.setDate(aboutImage.getDate());

        aboutImgService.saveImageUrl(image);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
