package com.macquochuy.exercise02.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.macquochuy.exercise02.Entity.Like;
import com.macquochuy.exercise02.Entity.LikeId;
import com.macquochuy.exercise02.service.LikeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/likes")
public class LikeController {

    private final LikeService likeService;

    // Create Like REST API
    @PostMapping
    public ResponseEntity<Like> createLike(@RequestBody Like like) {
        Like savedLike = likeService.createLike(like);
        return new ResponseEntity<>(savedLike, HttpStatus.CREATED);
    }

    // Get Like by id REST API
    // http://localhost:8080/api/likes/1
    @GetMapping("{userId}/{productId}/{likeDate}")
    public ResponseEntity<Like> getLikeById(@PathVariable("userId") Long userId,
            @PathVariable("productId") Long productId,
            @PathVariable("likeDate") String likeDate) {
        LikeId likeId = new LikeId(userId, productId, likeDate);
        Like like = likeService.getLikeById(likeId);
        return new ResponseEntity<>(like, HttpStatus.OK);
    }

    // Get All Likes REST API
    // http://localhost:8080/api/likes
    @GetMapping
    public ResponseEntity<List<Like>> getAllLikes() {
        List<Like> likes = likeService.getAllLikes();
        return new ResponseEntity<>(likes, HttpStatus.OK);
    }

    // Update Like REST API
    @PutMapping("{userId}/{productId}/{likeDate}")
    // http://localhost:8080/api/likes/1
    public ResponseEntity<Like> updateLike(@PathVariable("userId") Long userId,
            @PathVariable("productId") Long productId,
            @PathVariable("likeDate") String likeDate,
            @RequestBody Like like) {
        // Thiết lập LikeId cho Like object
        LikeId likeId = new LikeId(userId, productId, likeDate);
        like.setLikeId(likeId);

        Like updatedLike = likeService.updateLike(like);
        if (updatedLike != null) {
            return new ResponseEntity<>(updatedLike, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Like REST API
    @DeleteMapping("{userId}/{productId}/{likeDate}")
    public ResponseEntity<String> deleteLike(@PathVariable("userId") Long userId,
            @PathVariable("productId") Long productId,
            @PathVariable("likeDate") String likeDate) {
        LikeId likeId = new LikeId(userId, productId, likeDate);
        likeService.deleteLike(likeId);
        return new ResponseEntity<>("Like successfully deleted!", HttpStatus.OK);
    }

}
