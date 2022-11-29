package ru.vladislav.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.vladislav.models.Position;
import ru.vladislav.service.PositionService;

import java.util.List;

@Controller
@RequestMapping("/position")
public class PositionController {

    private PositionService positionService;


    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @PostMapping
    public ResponseEntity<Position> savePosition(@RequestBody Position position) {
        return ResponseEntity.ok(positionService.save(position));
    }

    @PutMapping
    public ResponseEntity<Position> updatePosition(@RequestBody Position position) {
        return ResponseEntity.ok(positionService.update(position));
    }

    @GetMapping
    public ResponseEntity<List<Position>> getAllPosition() {
        return ResponseEntity.ok(positionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Position> getPositionById(@PathVariable Long id) {
        return ResponseEntity.ok(positionService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Position> deletePosition(@RequestBody Long id) {
        return ResponseEntity.ok(positionService.delete(id));
    }
}
