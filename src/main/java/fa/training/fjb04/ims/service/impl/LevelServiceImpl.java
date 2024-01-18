package fa.training.fjb04.ims.service.impl;

import fa.training.fjb04.ims.entity.common.Level;
import fa.training.fjb04.ims.repository.LevelRepository;
import fa.training.fjb04.ims.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;

    @Override
    public List<Level> getAll() {
        return levelRepository.findAll();
    }

    @Override
    public void create(Level level) {
        levelRepository.save(level);
    }

    @Override
    public Optional<Level> findById(Integer id) {
        return levelRepository.findById(id);
    }

    @Override
    public void update(Integer id) {

    }

    @Override
    public void delete(Integer id) {
        levelRepository.deleteById(id);
    }
}
