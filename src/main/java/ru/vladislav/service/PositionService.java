package ru.vladislav.service;

import ru.vladislav.models.Position;

import java.util.List;

public interface PositionService {

    Position save(Position position);

    Position update(Position position);

    List<Position> getAll();

    Position getById(long id);

    Position delete(long id);

}
