package fa.training.fjb04.ims.service;

import fa.training.fjb04.ims.entity.common.Benefit;

import java.util.List;
import java.util.Optional;

public interface BenefitService {
    List<Benefit> getAll();

    void create(Benefit benefit);

    Optional<Benefit> findById(Integer id);

    void update(Integer id);

    void delete(Integer id);
}
