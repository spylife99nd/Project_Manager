package fa.training.fjb04.ims.service.impl;

import fa.training.fjb04.ims.entity.common.Benefit;
import fa.training.fjb04.ims.repository.BenefitRepository;
import fa.training.fjb04.ims.service.BenefitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BenefitServiceImpl implements BenefitService {

    private final BenefitRepository benefitRepository;
    @Override
    public List<Benefit> getAll() {
        return benefitRepository.findAll();
    }

    @Override
    public void create(Benefit benefit) {
        benefitRepository.save(benefit);
    }

    @Override
    public Optional<Benefit> findById(Integer id) {
        return benefitRepository.findById(id);
    }

    @Override
    public void update(Integer id) {

    }

    @Override
    public void delete(Integer id) {
        benefitRepository.deleteById(id);
    }
}
