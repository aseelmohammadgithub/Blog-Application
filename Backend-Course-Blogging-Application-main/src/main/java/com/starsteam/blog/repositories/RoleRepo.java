package com.starsteam.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.starsteam.blog.entities.Role;

public interface RoleRepo  extends JpaRepository<Role, Integer>{

}
