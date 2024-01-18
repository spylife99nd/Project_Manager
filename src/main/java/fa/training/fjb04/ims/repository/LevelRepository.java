package fa.training.fjb04.ims.repository;

import fa.training.fjb04.ims.entity.common.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LevelRepository extends JpaRepository<Level, Integer> {
    @Query(
            "SELECT l FROM Level l " +
                    "JOIN JobLevel jl ON l.id = jl.level.id " +
                    "JOIN Job j ON j.id = jl.job.id " +
                    "WHERE j.id = :id"
    )
    List<Level> getAllByJobId(Integer id);
}
