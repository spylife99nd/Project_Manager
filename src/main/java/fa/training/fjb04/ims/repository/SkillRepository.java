package fa.training.fjb04.ims.repository;

import fa.training.fjb04.ims.entity.common.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skills, Integer> {
    @Query(
            "SELECT s FROM Skills s " +
                    "JOIN JobSkill js ON s.id = js.skills.id " +
                    "JOIN Job j ON j.id = js.job.id " +
                    "WHERE j.id = :id"
    )
    List<Skills> getAllByJobId(Integer id);
}
