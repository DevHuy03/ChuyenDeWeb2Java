package com.macquochuy.exercise03.controller;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.macquochuy.exercise03.entity.Slideshow;
import com.macquochuy.exercise03.service.SlideShowService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/slideShows")
public class SlideShowController {

    private SlideShowService slideShowService;

    // Create Slideshow REST API
    @PostMapping
    public ResponseEntity<Slideshow> createSlideShow(@RequestBody Slideshow slideShow) {
        Slideshow savedSlideShow = slideShowService.createSlideShow(slideShow);
        return new ResponseEntity<>(savedSlideShow, HttpStatus.CREATED);
    }

    // Get Slideshow by id REST API
    // http://localhost:8080/api/slideShows/{id}
    @GetMapping("{id}")
    public ResponseEntity<Slideshow> getSlideShowById(@PathVariable("id") UUID slideShowId) {
        Slideshow slideShow = slideShowService.getSlideShowById(slideShowId);
        return new ResponseEntity<>(slideShow, HttpStatus.OK);
    }

    // Get All SlideShows REST API
    // http://localhost:8080/api/slideShows
    @GetMapping
    public ResponseEntity<List<Slideshow>> getAllSlideShows() {
        List<Slideshow> slideShows = slideShowService.getAllSlideShows();
        return new ResponseEntity<>(slideShows, HttpStatus.OK);
    }

    // Update Slideshow REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/slideShows/{id}
    public ResponseEntity<Slideshow> updateSlideShow(@PathVariable("id") UUID slideShowId,
                                                      @RequestBody Slideshow slideShow) {
        slideShow.setId(slideShowId);
        Slideshow updatedSlideShow = slideShowService.updateSlideShow(slideShow);
        if (updatedSlideShow != null) {
            return new ResponseEntity<>(updatedSlideShow, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Slideshow REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSlideShow(@PathVariable("id") UUID slideShowId) {
        slideShowService.deleteSlideShow(slideShowId);
        return new ResponseEntity<>("Slideshow successfully deleted!", HttpStatus.OK);
    }
}
