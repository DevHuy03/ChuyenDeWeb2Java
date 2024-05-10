package com.macquochuy.exercise02.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise02.Entity.Like;
import com.macquochuy.exercise02.Entity.LikeId;
import com.macquochuy.exercise02.Entity.Product;
import com.macquochuy.exercise02.Entity.User;
import com.macquochuy.exercise02.Repository.LikeRepository;
import com.macquochuy.exercise02.service.LikeService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;

    @Override
    public Like createLike(Like like) {
        like.setCreated_at(new Date());
        like.setUpdated_at(new Date());
        return likeRepository.save(like);
    }

    @Override
    public Like getLikeById(LikeId likeId) {
        Optional<Like> optionalLike = likeRepository.findById(likeId);
        return optionalLike.orElse(null);
    }

    @Override
    public List<Like> getAllLikes() {
        return likeRepository.findAll();
    }

    @Override
    public Like updateLike(Like like) {
        User user = like.getUser();
        Product product = like.getProduct();
        Date like_date = like.getLike_date();
        LikeId likeId = new LikeId(user, product, like_date);
        Optional<Like> optionalExistingLike = likeRepository.findById(likeId);
        if (optionalExistingLike.isPresent()) {
            Like existingLike = optionalExistingLike.get();
            existingLike.setUpdated_at(new Date());
            return likeRepository.save(existingLike);
        } else {
            return null;
        }
    }

    @Override
    public void deleteLike(LikeId likeId) {
        likeRepository.deleteById(likeId);
    }
}
