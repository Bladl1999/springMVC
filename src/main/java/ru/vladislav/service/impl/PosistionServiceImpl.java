package ru.vladislav.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vladislav.dao.PositionDAO;
import ru.vladislav.models.Position;
import ru.vladislav.service.PositionService;

import java.util.List;

@Service
public class PosistionServiceImpl implements PositionService {

    private PositionDAO positionDAO;

    @Autowired
    public PosistionServiceImpl(PositionDAO positionDAO) {
        this.positionDAO = positionDAO;
    }


    public Position save(Position position) {
        return positionDAO.save(position);
    }

    public Position update(Position position) {
        return positionDAO.update(position);
    }

    public List<Position> getAll() {
        return positionDAO.getAll();
    }

    public Position getById(long id) {
        return positionDAO.findById(id);
    }

    public Position delete(long id) {
        return positionDAO.delete(id);
    }
}
