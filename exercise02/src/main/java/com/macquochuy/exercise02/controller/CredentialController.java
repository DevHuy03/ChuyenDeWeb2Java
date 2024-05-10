package com.macquochuy.exercise02.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.macquochuy.exercise02.Entity.Credential;
import com.macquochuy.exercise02.service.CredentialService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/credentials")
public class CredentialController {

    private final CredentialService credentialService;

    // Create Credential REST API
    @PostMapping
    public ResponseEntity<Credential> createCredential(@RequestBody Credential credential) {
        Credential savedCredential = credentialService.createCredential(credential);
        return new ResponseEntity<>(savedCredential, HttpStatus.CREATED);
    }

    // Get Credential by id REST API
    // http://localhost:8080/api/credentials/1
    @GetMapping("{id}")
    public ResponseEntity<Credential> getCredentialById(@PathVariable("id") Long credentialId) {
        Credential credential = credentialService.getCredentialById(credentialId);
        return new ResponseEntity<>(credential, HttpStatus.OK);
    }

    // Get All Credentials REST API
    // http://localhost:8080/api/credentials
    @GetMapping
    public ResponseEntity<List<Credential>> getAllCredentials() {
        List<Credential> credentials = credentialService.getAllCredentials();
        return new ResponseEntity<>(credentials, HttpStatus.OK);
    }

    // Update Credential REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/credentials/1
    public ResponseEntity<Credential> updateCredential(@PathVariable("id") Long credentialId,
                                                       @RequestBody Credential credential) {
        credential.setCredential_id(credentialId); // Thiết lập id cho thông tin đăng nhập cần cập nhật
        Credential updatedCredential = credentialService.updateCredential(credential);
        if (updatedCredential != null) {
            return new ResponseEntity<>(updatedCredential, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Credential REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCredential(@PathVariable("id") Long credentialId) {
        credentialService.deleteCredential(credentialId);
        return new ResponseEntity<>("Credential successfully deleted!", HttpStatus.OK);
    }
}
