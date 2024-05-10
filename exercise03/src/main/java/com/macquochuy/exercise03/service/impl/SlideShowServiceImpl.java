package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.Slideshow;
import com.macquochuy.exercise03.Repository.SlideshowRepository;
import com.macquochuy.exercise03.service.SlideShowService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SlideShowServiceImpl implements SlideShowService {
    private SlideshowRepository slideShowRepository;

    @Override
    public Slideshow createSlideShow(Slideshow slideShow) {
        return slideShowRepository.save(slideShow);
    }

    @Override
    public Slideshow getSlideShowById(UuidGenerator slideShowId) {
        Optional<Slideshow> optionalSlideShow = slideShowRepository.findById(slideShowId);
        return optionalSlideShow.orElse(null);
    }

    @Override
    public List<Slideshow> getAllSlideShows() {
        return slideShowRepository.findAll();
    }

    @Override
    public Slideshow updateSlideShow(Slideshow slideShow) {
        Optional<Slideshow> optionalExistingSlideShow = slideShowRepository.findById(slideShow.getId());
        if (optionalExistingSlideShow.isPresent()) {
            Slideshow existingSlideShow = optionalExistingSlideShow.get();
            existingSlideShow.setTitle(slideShow.getTitle());
            existingSlideShow.setDestination_url(slideShow.getDestination_url());
            existingSlideShow.setImage(slideShow.getImage());
            existingSlideShow.setPlaceholder(slideShow.getPlaceholder());
            existingSlideShow.setDescription(slideShow.getDescription());
            existingSlideShow.setBtn_label(slideShow.getBtn_label());
            existingSlideShow.setPublished(slideShow.isPublished());
            existingSlideShow.setClicks(slideShow.getClicks());
            existingSlideShow.setStyles(slideShow.getStyles());
            existingSlideShow.setUpdated_at(new Date());
            existingSlideShow.setUpdated_by(slideShow.getUpdated_by());

            Slideshow updatedSlideShow = slideShowRepository.save(existingSlideShow);
            return updatedSlideShow;
        }

        return null; // Hoặc xử lý theo yêu cầu của bạn khi không tìm thấy Slideshow tồn tại
    }

    @Override
    public void deleteSlideShow(UuidGenerator slideShowId) {
        slideShowRepository.deleteById(slideShowId);
    }
}
