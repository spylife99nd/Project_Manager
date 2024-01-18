package fa.training.fjb04.ims.repository;

import fa.training.fjb04.ims.entity.User;
import fa.training.fjb04.ims.entity.common.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(
            "SELECT u.fullName FROM User u " +
                    "JOIN UserSchedule us ON u.userId = us.user.userId " +
                    "JOIN Schedule s ON s.id = us.schedule.id " +
                    "WHERE s.id = :id"
    )
    List<String> getAllNameByScheduleId(Integer id);

    @Query ("SELECT u.fullName FROM User u")
    List<String> getAllInterviewerName ();

}
