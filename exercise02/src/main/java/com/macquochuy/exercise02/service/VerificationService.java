package com.macquochuy.exercise02.service;

import java.util.List;

import com.macquochuy.exercise02.Entity.VerificationToken;

public interface VerificationService {
    VerificationToken createVerification(VerificationToken verificationToken);
    VerificationToken getVerificationById(Long verificationId);
    List<VerificationToken> getAllVerifications();
    VerificationToken updateVerification(VerificationToken verification);
    void deleteVerification(Long verificationId);
}

