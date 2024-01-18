package fa.training.fjb04.ims.service.impl;

import fa.training.fjb04.ims.entity.common.Skills;
import fa.training.fjb04.ims.repository.SkillRepository;
import fa.training.fjb04.ims.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    @Override
    public List<Skills> getAll() {
        return skillRepository.findAll();
    }

    @Override
    public void create(Skills skills) {
        skillRepository.save(skills);
    }

    @Override
    public Optional<Skills> findById(Integer id) {
        return skillRepository.findById(id);
    }

    @Override
    public void update(Integer id) {

    }

    @Override
    public void delete(Integer id) {
        skillRepository.deleteById(id);
    }
}
