package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.Gallery;
import com.macquochuy.exercise03.Repository.GalleryRepository;
import com.macquochuy.exercise03.service.GalleryService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GalleryServiceImpl implements GalleryService {
    private GalleryRepository galleryRepository;

    @Override
    public Gallery createGallery(Gallery gallery) {
        return galleryRepository.save(gallery);
    }

    @Override
    public Gallery getGalleryById(UuidGenerator galleryId) {
        Optional<Gallery> optionalGallery = galleryRepository.findById(galleryId);
        return optionalGallery.orElse(null);
    }

    @Override
    public List<Gallery> getAllGalleries() {
        return galleryRepository.findAll();
    }

    @Override
    public Gallery updateGallery(Gallery gallery) {
        Optional<Gallery> optionalExistingGallery = galleryRepository.findById(gallery.getId());
        if (optionalExistingGallery.isPresent()) {
            Gallery existingGallery = optionalExistingGallery.get();
            existingGallery.setProduct_id(gallery.getProduct_id());
            existingGallery.setImage(gallery.getImage());
            existingGallery.setPlaceholder(gallery.getPlaceholder());
            existingGallery.set_thumbnail(gallery.is_thumbnail());
            Gallery updatedGallery = galleryRepository.save(existingGallery);
            return updatedGallery;
        }

        return null;
    }

    @Override
    public void deleteGallery(UuidGenerator galleryId) {
        galleryRepository.deleteById(galleryId);
    }
}
