package com.managementlogisticsystem.managementlogisticsystem.user.repository;

import com.managementlogisticsystem.managementlogisticsystem.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {
    void deleteUserById(Long id);

    @Query("SELECT u FROM User u WHERE u.name= :name AND u.password = :password ")
    public Optional<User> login(@Param("name") String name, @Param("password") String password);
}
