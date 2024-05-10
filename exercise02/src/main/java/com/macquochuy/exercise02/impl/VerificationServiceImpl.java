package com.macquochuy.exercise02.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise02.Entity.VerificationToken;
import com.macquochuy.exercise02.Repository.VerificationRepository;
import com.macquochuy.exercise02.service.VerificationService;

@Service
public class VerificationServiceImpl implements VerificationService {

    private final VerificationRepository VerificationRepository;

    @Autowired
    public VerificationServiceImpl(VerificationRepository VerificationRepository) {
        this.VerificationRepository = VerificationRepository;
    }

    @Override
    public VerificationToken createVerification(VerificationToken verificationToken) {
        return VerificationRepository.save(verificationToken);
    }

    @Override
    public VerificationToken getVerificationById(Long verificationId) {
        return VerificationRepository.findById(verificationId).orElse(null);
    }

    @Override
    public List<VerificationToken> getAllVerifications() {
        return VerificationRepository.findAll();
    }

    @Override
    public VerificationToken updateVerification(VerificationToken verificationToken) {
        return VerificationRepository.save(verificationToken);
    }

    @Override
    public void deleteVerification(Long verificationId) {
        VerificationRepository.deleteById(verificationId);
    }
}
