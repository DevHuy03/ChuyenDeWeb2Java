package com.aaa.exercise03.service;

import java.util.List;

import com.aaa.exercise03.entity.Role;

public interface RoleService {

    Role createRole(Role role);

    Role getRoleById(Integer roleId);

    List<Role> getAllRoles();

    Role updateRole(Role role);

    void deleteRole(Integer roleId);
    
}