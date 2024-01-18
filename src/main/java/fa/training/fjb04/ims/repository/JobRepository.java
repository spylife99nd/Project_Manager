package fa.training.fjb04.ims.repository;

import fa.training.fjb04.ims.entity.Job;
import fa.training.fjb04.ims.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
    @Query(
            "SELECT j FROM Job j " +
                    "WHERE (:keyword IS NULL OR LOWER(j.title) LIKE LOWER(CONCAT('%', :keyword, '%'))) " +
                    "    AND (:status IS NULL OR j.status = :status)"
    )
    Page<Job> getSearchList(String keyword, String status, Pageable pageable);
}
