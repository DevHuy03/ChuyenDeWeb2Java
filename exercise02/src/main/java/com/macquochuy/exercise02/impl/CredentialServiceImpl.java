package com.macquochuy.exercise02.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise02.Entity.Credential;
import com.macquochuy.exercise02.Repository.CredentialRepository;
import com.macquochuy.exercise02.service.CredentialService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CredentialServiceImpl implements CredentialService {
    private final CredentialRepository credentialRepository;

    @Override
    public Credential createCredential(Credential credential) {
        credential.setCreated_at(new Date());
        credential.setUpdated_at(new Date());
        return credentialRepository.save(credential);
    }

    @Override
    public Credential getCredentialById(Long credentialId) {
        Optional<Credential> optionalCredential = credentialRepository.findById(credentialId);
        return optionalCredential.orElse(null);
    }

    @Override
    public List<Credential> getAllCredentials() {
        return credentialRepository.findAll();
    }

    @Override
    public Credential updateCredential(Credential credential) {
        Optional<Credential> optionalExistingCredential = credentialRepository.findById(credential.getCredential_id());

        if (optionalExistingCredential.isPresent()) {
            Credential existingCredential = optionalExistingCredential.get();
            existingCredential.setUser(credential.getUser());
            existingCredential.setUsername(credential.getUsername());
            existingCredential.setPassword(credential.getPassword());
            existingCredential.setRole(credential.getRole());
            existingCredential.set_enabled(credential.is_enabled());  // Sử dụng getter và setter tương ứng
            existingCredential.set_account_non_expired(credential.is_account_non_expired());
            existingCredential.set_account_non_locked(credential.is_account_non_locked());
            existingCredential.set_credentials_non_expired(credential.is_credentials_non_expired());

            existingCredential.setUpdated_at(new Date());

            return credentialRepository.save(existingCredential);
        } else {
            // Trả về null nếu credential không tồn tại
            return null;
        }
    }

    @Override
    public void deleteCredential(Long credentialId) {
        credentialRepository.deleteById(credentialId);
    }
}
