package com.managementlogisticsystem.managementlogisticsystem.user.service;

import com.managementlogisticsystem.managementlogisticsystem.user.model.User;
import com.managementlogisticsystem.managementlogisticsystem.user.permission.Permission;
import com.managementlogisticsystem.managementlogisticsystem.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

   public void deleteUser(Long id){
        userRepository.deleteUserById(id);
    }


    public List<Permission> getPermission(Long id){
        var user =  userRepository.findById(id);
        return user.map(User::getPermissions).orElse(null);
    }
}
