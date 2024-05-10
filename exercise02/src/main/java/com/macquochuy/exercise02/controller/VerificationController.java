package com.macquochuy.exercise02.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.macquochuy.exercise02.Entity.VerificationToken;
import com.macquochuy.exercise02.service.VerificationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/verifications")
public class VerificationController {

    private final VerificationService verificationService;

    @PostMapping
    public ResponseEntity<VerificationToken> createVerification(@RequestBody VerificationToken verificationToken) {
        VerificationToken savedVerification = verificationService.createVerification(verificationToken);
        return new ResponseEntity<>(savedVerification, HttpStatus.CREATED);
    }

    // http://localhost:8080/api/verifications/1
    @GetMapping("{id}")
    public ResponseEntity<VerificationToken> getVerificationById(@PathVariable("id") Long verificationId) {
        VerificationToken verification = verificationService.getVerificationById(verificationId);
        return new ResponseEntity<>(verification, HttpStatus.OK);
    }

    // http://localhost:8080/api/verifications
    @GetMapping
    public ResponseEntity<List<VerificationToken>> getAllVerifications() {
        List<VerificationToken> verifications = verificationService.getAllVerifications();
        return new ResponseEntity<>(verifications, HttpStatus.OK);
    }

    // Update Verification REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/verifications/1
    public ResponseEntity<VerificationToken> updateVerification(@PathVariable("id") Long verificationId,
                                                 @RequestBody VerificationToken verificationToken) {
        verificationToken.setVerification_token_id(verificationId);
        VerificationToken updatedVerification = verificationService.updateVerification(verificationToken);
        if (updatedVerification != null) {
            return new ResponseEntity<>(updatedVerification, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Verification REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteVerification(@PathVariable("id") Long verificationId) {
        verificationService.deleteVerification(verificationId);
        return new ResponseEntity<>("Verification successfully deleted!", HttpStatus.OK);
    }
}
