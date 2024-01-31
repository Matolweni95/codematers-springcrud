package codemasters.codematersspringcrud.service;

import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codemasters.codematersspringcrud.entity.Gallery;
import codemasters.codematersspringcrud.entity.User;
import codemasters.codematersspringcrud.repository.GalleryRepository;
import codemasters.codematersspringcrud.repository.UserRepository;

@Service
public class GalleryService {

    private final GalleryRepository galleryRepository;
    @Autowired
    private UserRepository userRepository;

    public GalleryService(GalleryRepository galleryRepository) {
        this.galleryRepository = galleryRepository;
    }

    public Gallery saveGallery(Gallery gallery, Integer id) {
        gallery.setCreatedAt(Instant.now());
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            gallery.setUser(user.get());
        }
        return galleryRepository.save(gallery);
    }

    public List<Gallery> saveAllGalleries(List<Gallery> galleries) {
        galleries.forEach(gallery -> gallery.setCreatedAt(Instant.now()));
        return galleryRepository.saveAll(galleries);
    }

    public Optional<Gallery> getGalleryById(Integer id) {
        return galleryRepository.findById(id);
    }

    public List<Gallery> findGalleryByUserId(Integer userId) {
        return galleryRepository.findByUserId(userId);
    }

    public List<Gallery> findGalleryByEvent(String event) {
        return galleryRepository.findByEvent(event);
    }

    public List<Gallery> getAllGalleries() {
        return galleryRepository.findAll();
    }

    public Gallery updateGallery(Integer id, Gallery updatedGallery) {
        Gallery existingGallery = galleryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Gallery not found"));

        existingGallery.setCaption(updatedGallery.getCaption());
        existingGallery.setDescription(updatedGallery.getDescription());
        existingGallery.setEvent(updatedGallery.getEvent());
        existingGallery.setImageUrl(updatedGallery.getImageUrl());

        existingGallery.setUpdatedAt(Instant.now());
        return galleryRepository.save(existingGallery);
    }

    public void deleteAllGalleries() {
        galleryRepository.deleteAll();
    }

    public void deleteGalleryById(Integer id) {
        galleryRepository.deleteById(id);
    }
}
