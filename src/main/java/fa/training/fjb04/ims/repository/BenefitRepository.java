package fa.training.fjb04.ims.repository;

import fa.training.fjb04.ims.entity.common.Benefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenefitRepository extends JpaRepository<Benefit, Integer> {
}
