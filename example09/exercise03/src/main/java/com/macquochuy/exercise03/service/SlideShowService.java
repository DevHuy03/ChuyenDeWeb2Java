package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.macquochuy.exercise03.entity.Slideshow;

public interface SlideShowService {

    Slideshow createSlideShow(Slideshow slideShow);

    Slideshow getSlideShowById(UUID SlideShowId);

    List<Slideshow> getAllSlideShows();

    Slideshow updateSlideShow(Slideshow slideShow);
    
    void deleteSlideShow(UUID SlideShowId);
}