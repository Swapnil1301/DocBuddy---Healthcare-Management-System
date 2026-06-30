package com.example.DocBuddy.role.service;

import com.example.DocBuddy.res.Response;
import com.example.DocBuddy.role.entity.Role;

import java.util.List;

public interface RoleService {

    Response<Role> createRole(Role roleRequest);

    Response<Role> updateRole(Role roleRequest);

    Response<List<Role>> getAllRoles();

    Response<?> deleteRole(Long id);
}
