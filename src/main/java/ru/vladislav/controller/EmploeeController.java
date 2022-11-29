package ru.vladislav.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.vladislav.models.Emploee;
import ru.vladislav.service.EmploeeService;

import java.util.List;

@Controller
@RequestMapping("/emploee")
public class EmploeeController {

    private EmploeeService emploeeService;


    public EmploeeController(EmploeeService emploeeService) {
        this.emploeeService = emploeeService;
    }

    @PostMapping
    public ResponseEntity<Emploee> saveEmploee(@RequestBody Emploee emploee) {
        return ResponseEntity.ok(emploeeService.save(emploee));
    }

    @PutMapping
    public ResponseEntity<Emploee> updateEmploee(@RequestBody Emploee emploee) {
        return ResponseEntity.ok(emploeeService.update(emploee));
    }

    @GetMapping
    public ResponseEntity<List<Emploee>> getAllEmploee() {
        return ResponseEntity.ok(emploeeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emploee> getEmploeeById(@PathVariable Long id) {
        return ResponseEntity.ok(emploeeService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Emploee> deleteEmploee(@RequestBody Long id) {
        return ResponseEntity.ok(emploeeService.delete(id));
    }
}
