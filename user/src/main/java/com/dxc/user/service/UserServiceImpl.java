package com.dxc.user.service;

import com.dxc.user.entity.UserEntity;
import com.dxc.user.exception.ResourceNotFoundException;
import com.dxc.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        Optional<UserEntity> userEntityOptional = this.userRepository.findById(userEntity.getId());

        if(userEntityOptional.isPresent()) {
            UserEntity userUpdate = userEntityOptional.get();
            userUpdate.setActive(userEntity.isActive());
            userUpdate.setUsername(userEntity.getUsername());
            userUpdate.setPassword(userEntity.getPassword());
            userUpdate.setFullname(userEntity.getFullname());
            userUpdate.setAddress(userEntity.getAddress());
            userUpdate.setEmail(userEntity.getEmail());
            userUpdate.setLimit_consume(userEntity.getLimit_consume());
            userUpdate.setRole(userEntity.setRole("USER"));
            userRepository.save(userUpdate);
            return userUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id: " + userEntity.getId());
        }

    }

    @Override
    public List<UserEntity> getAllUser() {

        return this.userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(long userId) {
        Optional<UserEntity> userEntityOptional = this.userRepository.findById(userId);

        if(userEntityOptional.isPresent()) {
            return userEntityOptional.get();
        }else {
            throw new ResourceNotFoundException("Record not found with id: " + userId);
        }
    }

    @Override
    public void deleteUser(long userId) {
        Optional<UserEntity> userEntityOptional = this.userRepository.findById(userId);

        if(userEntityOptional.isPresent()) {
            this.userRepository.delete(userEntityOptional.get());
        }else {
            throw new ResourceNotFoundException("Record not found with id: " + userId);
        }
    }

    @Override
    public UserEntity getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
