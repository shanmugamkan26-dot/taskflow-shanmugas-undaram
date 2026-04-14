package com.example.zomato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.zomato.model.Project;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByOwnerId(Long ownerId);
}