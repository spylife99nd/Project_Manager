package fa.training.fjb04.ims.service;

import fa.training.fjb04.ims.entity.common.Level;

import java.util.List;
import java.util.Optional;

public interface LevelService {
    List<Level> getAll();

    void create(Level level);

    Optional<Level> findById(Integer id);

    void update(Integer id);

    void delete(Integer id);
}
