package com.company.bpmdemo.security;

import com.company.bpmdemo.entity.User;
import io.jmix.security.role.annotation.JpqlRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;

@RowLevelRole(name = "UsersAccessRole", code = UsersAccessRole.CODE)
public interface UsersAccessRole {
    String CODE = "users-access-role";

    @JpqlRowLevelPolicy(entityClass = User.class, where = "{E}.username <> 'admin'")
    void user();
}