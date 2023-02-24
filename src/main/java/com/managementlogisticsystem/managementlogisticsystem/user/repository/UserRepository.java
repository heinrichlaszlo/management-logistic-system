package com.managementlogisticsystem.managementlogisticsystem.user.repository;

import com.managementlogisticsystem.managementlogisticsystem.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    void deleteUserById(Long id);
}
