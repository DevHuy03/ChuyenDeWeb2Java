package com.macquochuy.exercise03.controller;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.macquochuy.exercise03.entity.StaffAccount;
import com.macquochuy.exercise03.service.StaffAccountService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/staffAccounts")
public class StaffAccountController {

    private StaffAccountService staffAccountService;

    // Create StaffAccount REST API
    @PostMapping
    public ResponseEntity<StaffAccount> createStaffAccount(@RequestBody StaffAccount staffAccount) {
        StaffAccount savedStaffAccount = staffAccountService.createStaffAccount(staffAccount);
        return new ResponseEntity<>(savedStaffAccount, HttpStatus.CREATED);
    }

    // Get StaffAccount by id REST API
    // http://localhost:8080/api/staffAccounts/{id}
    @GetMapping("{id}")
    public ResponseEntity<StaffAccount> getStaffAccountById(@PathVariable("id") UUID staffAccountId) {
        StaffAccount staffAccount = staffAccountService.getStaffAccountById(staffAccountId);
        return new ResponseEntity<>(staffAccount, HttpStatus.OK);
    }

    // Get All StaffAccounts REST API
    // http://localhost:8080/api/staffAccounts
    @GetMapping
    public ResponseEntity<List<StaffAccount>> getAllStaffAccounts() {
        List<StaffAccount> staffAccounts = staffAccountService.getAllStaffAccounts();
        return new ResponseEntity<>(staffAccounts, HttpStatus.OK);
    }

    // Update StaffAccount REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/staffAccounts/{id}
    public ResponseEntity<StaffAccount> updateStaffAccount(@PathVariable("id") UUID staffAccountId,
                                                      @RequestBody StaffAccount staffAccount) {
        staffAccount.setId(staffAccountId);
        StaffAccount updatedStaffAccount = staffAccountService.updateStaffAccount(staffAccount);
        if (updatedStaffAccount != null) {
            return new ResponseEntity<>(updatedStaffAccount, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete StaffAccount REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStaffAccount(@PathVariable("id") UUID staffAccountId) {
        staffAccountService.deleteStaffAccount(staffAccountId);
        return new ResponseEntity<>("StaffAccount successfully deleted!", HttpStatus.OK);
    }
}
