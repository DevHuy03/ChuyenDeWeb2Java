package com.macquochuy.exercise03.controller;

import lombok.AllArgsConstructor;

import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.macquochuy.exercise03.entity.Tag;
import com.macquochuy.exercise03.service.TagService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/tags")
public class TagController {

    private TagService tagService;

    // Create Tag REST API
    @PostMapping
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        Tag savedTag = tagService.createTag(tag);
        return new ResponseEntity<>(savedTag, HttpStatus.CREATED);
    }

    // Get Tag by id REST API
    // http://localhost:8080/api/tags/{id}
    @GetMapping("{id}")
    public ResponseEntity<Tag> getTagById(@PathVariable("id") UuidGenerator tagId) {
        Tag tag = tagService.getTagById(tagId);
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    // Get All Tags REST API
    // http://localhost:8080/api/tags
    @GetMapping
    public ResponseEntity<List<Tag>> getAllTags() {
        List<Tag> tags = tagService.getAllTags();
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }

    // Update Tag REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/tags/{id}
    public ResponseEntity<Tag> updateTag(@PathVariable("id") UuidGenerator tagId,
                                                      @RequestBody Tag tag) {
        tag.setId(tagId);
        Tag updatedTag = tagService.updateTag(tag);
        if (updatedTag != null) {
            return new ResponseEntity<>(updatedTag, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Tag REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTag(@PathVariable("id") UuidGenerator tagId) {
        tagService.deleteTag(tagId);
        return new ResponseEntity<>("Tag successfully deleted!", HttpStatus.OK);
    }
}
