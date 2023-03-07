package com.managementlogisticsystem.managementlogisticsystem.user.service;

import com.managementlogisticsystem.managementlogisticsystem.user.exception.InvalidNameOrPasswordException;
import com.managementlogisticsystem.managementlogisticsystem.user.exception.LockedUserException;
import com.managementlogisticsystem.managementlogisticsystem.user.model.User;
import com.managementlogisticsystem.managementlogisticsystem.user.permission.Permission;
import com.managementlogisticsystem.managementlogisticsystem.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

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

    public User login(String name, String password){
        var user = userRepository.login(name, password);
        if (user.isEmpty()){
            throw new InvalidNameOrPasswordException("Invalid name or password");
        }
       guardLockedUser(user.get());
        user.get().setLastLoginTime(LocalDateTime.now());
        return user.get();
    }

    public List<Permission> getPermission(Long id){
        var user =  userRepository.findById(id);
        if(user.isPresent() && user.get().getLocked().equals(false)){
            return user.get().getPermissions();
        }
        return null;
    }

    private void guardLockedUser(User user){
        if (user.getLocked()){
            throw new LockedUserException("User is locked");
        }
    }
}
