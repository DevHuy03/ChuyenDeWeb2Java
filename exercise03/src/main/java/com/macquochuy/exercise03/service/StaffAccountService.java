package com.macquochuy.exercise03.service;

import java.util.List;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.StaffAccount;

public interface StaffAccountService {

    StaffAccount createStaffAccount(StaffAccount staffAccount);

    StaffAccount getStaffAccountById(UuidGenerator staffAccountId);

    List<StaffAccount> getAllStaffAccounts();

    StaffAccount updateStaffAccount(StaffAccount staffAccount);
    
    void deleteStaffAccount(UuidGenerator staffAccountId);
}