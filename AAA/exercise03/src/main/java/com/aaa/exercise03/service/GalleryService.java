package com.aaa.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.aaa.exercise03.entity.Gallery;

public interface GalleryService {

    Gallery createGallery(Gallery gallery);

    Gallery getGalleryById(UUID galleryId);

    List<Gallery> getAllGalleries();

    Gallery updateGallery(Gallery gallery);
    
    void deleteGallery(UUID galleryId);

}