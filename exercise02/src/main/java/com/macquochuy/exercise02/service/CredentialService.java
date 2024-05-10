package com.macquochuy.exercise02.service;

import java.util.List;

import com.macquochuy.exercise02.Entity.Credential;

public interface CredentialService {
    Credential createCredential(Credential credential);
    Credential getCredentialById(Long credentialId);
    List<Credential> getAllCredentials();
    Credential updateCredential(Credential credential);
    void deleteCredential(Long credentialId);
}
