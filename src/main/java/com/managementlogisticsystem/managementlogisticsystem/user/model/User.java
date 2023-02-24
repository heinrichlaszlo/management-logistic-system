package com.managementlogisticsystem.managementlogisticsystem.user.model;

import com.managementlogisticsystem.managementlogisticsystem.user.permission.Permission;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String name;

    private String password;

    private LocalDateTime lastLoginTime;

    private Boolean locked;

    @ElementCollection
    private List<Permission> permissions;



}
