package fa.training.fjb04.ims.service;

import fa.training.fjb04.ims.entity.common.Skills;

import java.util.List;
import java.util.Optional;

public interface SkillService {
    List<Skills> getAll();

    void create(Skills skills);

    Optional<Skills> findById(Integer id);

    void update(Integer id);

    void delete(Integer id);
}
