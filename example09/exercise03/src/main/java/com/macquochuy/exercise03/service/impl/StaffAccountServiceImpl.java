package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.StaffAccount;
import com.macquochuy.exercise03.Repository.StaffAccountRepository;
import com.macquochuy.exercise03.service.StaffAccountService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StaffAccountServiceImpl implements StaffAccountService {
    private StaffAccountRepository staffAccountRepository;

    @Override
    public StaffAccount createStaffAccount(StaffAccount staffAccount) {
        return staffAccountRepository.save(staffAccount);
    }

    @Override
    public StaffAccount getStaffAccountById(UUID staffAccountId) {
        Optional<StaffAccount> optionalStaffAccount = staffAccountRepository.findById(staffAccountId);
        return optionalStaffAccount.orElse(null);
    }

    @Override
    public List<StaffAccount> getAllStaffAccounts() {
        return staffAccountRepository.findAll();
    }

    @Override
    public StaffAccount updateStaffAccount(StaffAccount staffAccount) {
        Optional<StaffAccount> optionalExistingStaffAccount = staffAccountRepository
                .findById(staffAccount.getId());
        if (optionalExistingStaffAccount.isPresent()) {
            StaffAccount existingStaffAccount = optionalExistingStaffAccount.get();
            existingStaffAccount.setRole_id(staffAccount.getRole_id());
            existingStaffAccount.setFirst_name(staffAccount.getFirst_name());
            existingStaffAccount.setLast_name(staffAccount.getLast_name());
            existingStaffAccount.setPhone_number(staffAccount.getPhone_number());
            existingStaffAccount.setEmail(staffAccount.getEmail());
            existingStaffAccount.setPassword_hash(staffAccount.getPassword_hash());
            existingStaffAccount.setActive(staffAccount.isActive());
            existingStaffAccount.setImage(staffAccount.getImage());
            existingStaffAccount.setPlaceholder(staffAccount.getPlaceholder());
            existingStaffAccount.setUpdated_at(new Date());
            existingStaffAccount.setUpdated_by(staffAccount.getUpdated_by());

            StaffAccount updatedStaffAccount = staffAccountRepository.save(existingStaffAccount);
            return updatedStaffAccount;
        }

        return null; // Hoặc xử lý theo yêu cầu của bạn khi không tìm thấy tài khoản nhân viên tồn tại
    }

    @Override
    public void deleteStaffAccount(UUID staffAccountId) {
        staffAccountRepository.deleteById(staffAccountId);
    }
}
