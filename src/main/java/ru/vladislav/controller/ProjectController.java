package ru.vladislav.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.vladislav.models.Project;
import ru.vladislav.service.ProjectService;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<Project> saveProject(@RequestBody Project project) {
        return ResponseEntity.ok(projectService.save(project));
    }

    @PutMapping
    public ResponseEntity<Project> updateProject(@RequestBody Project project) {
        return ResponseEntity.ok(projectService.update(project));
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProject() {
        return ResponseEntity.ok(projectService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Project> deleteProjectn(@RequestBody Long id) {
        return ResponseEntity.ok(projectService.delete(id));
    }
}
