package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.Tag;
import com.macquochuy.exercise03.Repository.TagRepository;
import com.macquochuy.exercise03.service.TagService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TagServiceImpl implements TagService {
    private TagRepository tagRepository;

    @Override
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag getTagById(UuidGenerator tagId) {
        Optional<Tag> optionalTag = tagRepository.findById(tagId);
        return optionalTag.orElse(null);
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag updateTag(Tag tag) {
        Optional<Tag> optionalExistingTag = tagRepository.findById(tag.getId());
        if (optionalExistingTag.isPresent()) {
            Tag existingTag = optionalExistingTag.get();
            existingTag.setTag_name(tag.getTag_name());
            existingTag.setIcon(tag.getIcon());
            existingTag.setUpdated_by(tag.getUpdated_by());

            Tag updatedTag = tagRepository.save(existingTag);
            return updatedTag;
        }

        return null; // Hoặc xử lý theo yêu cầu của bạn khi không tìm thấy tag tồn tại
    }

    @Override
    public void deleteTag(UuidGenerator tagId) {
        tagRepository.deleteById(tagId);
    }
}
