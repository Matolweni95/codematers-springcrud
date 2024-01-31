package codemasters.codematersspringcrud.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import codemasters.codematersspringcrud.entity.Gallery;
import codemasters.codematersspringcrud.service.GalleryService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/gallery")

public class GalleryController {
    private final GalleryService galleryService;

    public GalleryController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Gallery>> getAllGalleries() {
        List<Gallery> galleries = galleryService.getAllGalleries();
        return new ResponseEntity<>(galleries, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gallery> getGalleryById(@PathVariable Integer id) {
        Optional<Gallery> gallery = galleryService.getGalleryById(id);
        return gallery.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findByUser/{userId}")
    public ResponseEntity<List<Gallery>> getGalleriesByUserId(@PathVariable Integer userId) {
        List<Gallery> galleries = galleryService.findGalleryByUserId(userId);
        return new ResponseEntity<>(galleries, HttpStatus.OK);
    }

    @GetMapping("/findByEvent/{event}")
    public ResponseEntity<List<Gallery>> getGalleriesByEvent(@PathVariable String event) {
        List<Gallery> galleries = galleryService.findGalleryByEvent(event);
        return new ResponseEntity<>(galleries, HttpStatus.OK);
    }

    @PostMapping("/save/{userId}")
    public ResponseEntity<Gallery> saveGallery(@RequestBody Gallery gallery, @PathVariable Integer userId) {
        Gallery savedGallery = galleryService.saveGallery(gallery, userId);
        return new ResponseEntity<>(savedGallery, HttpStatus.CREATED);
    }

    @PostMapping("/save/all")
    public ResponseEntity<List<Gallery>> saveAllGalleries(@RequestBody List<Gallery> galleries) {
        List<Gallery> savedGalleries = galleryService.saveAllGalleries(galleries);
        return new ResponseEntity<>(savedGalleries, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Gallery> updateGallery(@PathVariable Integer id, @RequestBody Gallery updatedGallery) {
        try {
            Gallery updated = galleryService.updateGallery(id, updatedGallery);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGalleryById(@PathVariable Integer id) {
        try {
            galleryService.deleteGalleryById(id);
            return new ResponseEntity<>("Gallery with ID " + id + " has been deleted", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<String> deleteAllGalleries() {
        try {
            galleryService.deleteAllGalleries();
            return new ResponseEntity<>("All Galleries have been deleted", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Error deleting galleries", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
