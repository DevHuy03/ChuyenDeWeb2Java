package com.aaa.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.aaa.exercise03.Repository.GalleryRepository;
import com.aaa.exercise03.entity.Gallery;
import com.aaa.exercise03.service.GalleryService;

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
    public Gallery getGalleryById(UUID galleryId) {
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
    public void deleteGallery(UUID galleryId) {
        galleryRepository.deleteById(galleryId);
    }
}
