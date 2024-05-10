package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.macquochuy.exercise03.entity.Tag;

public interface TagService {
    Tag addTag(Tag tag);

    List<Tag> getAllTags();

    void deleteTag(UUID tagId);
}
