package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.Gallery;

public interface GalleryService {

    Gallery createGallery(Gallery gallery);

    Gallery getGalleryById(UuidGenerator galleryId);

    List<Gallery> getAllGalleries();

    Gallery updateGallery(Gallery gallery);
    
    void deleteGallery(UuidGenerator galleryId);

}