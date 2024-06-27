package com.starsteam.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starsteam.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
