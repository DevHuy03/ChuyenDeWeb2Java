package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.macquochuy.exercise03.entity.Tag;

public interface TagService {

    Tag createTag(Tag tag);

    Tag getTagById(UUID tagId);

    List<Tag> getAllTags();

    Tag updateTag(Tag tag);
    
    void deleteTag(UUID tagId);
}