package com.starsteam.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starsteam.blog.entities.Comment;

public interface CommentRepo  extends JpaRepository<Comment	, Integer> {

}
