package com.macquochuy.exercise03.service;

import java.util.List;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.Slideshow;

public interface SlideShowService {

    Slideshow createSlideShow(Slideshow slideShow);

    Slideshow getSlideShowById(UuidGenerator SlideShowId);

    List<Slideshow> getAllSlideShows();

    Slideshow updateSlideShow(Slideshow slideShow);
    
    void deleteSlideShow(UuidGenerator SlideShowId);
}