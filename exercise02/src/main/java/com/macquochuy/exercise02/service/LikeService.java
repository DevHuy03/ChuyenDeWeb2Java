package com.macquochuy.exercise02.service;

import java.util.List;

import com.macquochuy.exercise02.Entity.Like;
import com.macquochuy.exercise02.Entity.LikeId;

public interface LikeService {
    Like createLike(Like like);
    Like getLikeById(LikeId likeId);
    List<Like> getAllLikes();
    Like updateLike(Like like);
    void deleteLike(LikeId likeId);
    // Update Like service method
}
