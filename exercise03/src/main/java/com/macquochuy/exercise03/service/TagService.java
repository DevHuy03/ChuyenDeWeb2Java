package com.macquochuy.exercise03.service;

import java.util.List;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.Tag;

public interface TagService {

    Tag createTag(Tag tag);

    Tag getTagById(UuidGenerator tagId);

    List<Tag> getAllTags();

    Tag updateTag(Tag tag);
    
    void deleteTag(UuidGenerator tagId);
}