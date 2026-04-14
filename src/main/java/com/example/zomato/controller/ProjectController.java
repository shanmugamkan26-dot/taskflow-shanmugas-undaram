package com.example.zomato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.zomato.model.Project;
import com.example.zomato.repository.ProjectRepository;
import com.example.zomato.config.JwtUtil;

import java.util.List;
import com.example.zomato.model.User;
import com.example.zomato.repository.UserRepository;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private JwtUtil jwtUtil;

    
   @PostMapping
public Project createProject(@RequestBody Project project,
                             @RequestHeader("Authorization") String token) {

    String email = jwtUtil.extractEmail(token.substring(7));

    User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));

    project.setOwnerId(user.getId());

    return projectRepository.save(project);
}
   
    @GetMapping
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    
    @GetMapping("/{id}")
    public Project getProject(@PathVariable Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
    }

    
    @DeleteMapping("/{id}")
public ResponseEntity<String> deleteProject(@PathVariable Long id) {

    Project project = projectRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Project not found"));

    projectRepository.delete(project);

    return ResponseEntity.ok("Project deleted");
}
}