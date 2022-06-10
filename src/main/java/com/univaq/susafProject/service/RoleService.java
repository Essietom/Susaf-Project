package com.univaq.susafProject.service;

import com.univaq.susafProject.model.Role;
import com.univaq.susafProject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public List<Role> getAllRoles()
    {
        List<Role> roles = new ArrayList<Role>();
        roleRepository.findAll().forEach(role1 -> roles.add(role1));
        return roles;
    }

    public Role saveOrUpdateRole(Role role )
    {
        return roleRepository.save(role);
    }



    public void delete(String roleId)
    {
        roleRepository.deleteById(roleId);
    }
}
