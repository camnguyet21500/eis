package com.dxc.user.service;

import com.dxc.user.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity createUser(UserEntity employee);

    UserEntity updateUser(UserEntity employee);

    List<UserEntity> getAllUser();

    UserEntity getUserById(long employeeId);

    void deleteUser(long Id);
    UserEntity getUserByUsername(String username);
}
