package fa.training.fjb04.ims.repository;

import fa.training.fjb04.ims.entity.Schedule;
import fa.training.fjb04.ims.enums.Status;
import fa.training.fjb04.ims.enums.StatusSchedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    @Query(
            "SELECT s FROM Schedule s " +
//                    "JOIN UserSchedule us ON us.schedule.id = s.id " +
                    "left JOIN User u ON u.userId = s.mainInterviewer.userId " +
                    "WHERE (:keyword IS NULL OR LOWER(s.title) LIKE LOWER(CONCAT('%', :keyword, '%')))" +
                    "AND (:interviewer IS NULL OR u.fullName = :interviewer)" +
                    "AND (:status IS NULL OR s.statusSchedule = :status)"
    )
    Page<Schedule> searchScheduleList (String keyword, String interviewer, StatusSchedule status, Pageable pageable);


//    @Query(
//            "SELECT u.fullName FROM Schedule s " +
//                    "JOIN UserSchedule us ON us.schedule.id = s.id " +
//                    "JOIN User u ON u.userId = us.user.userId " +
//                    "WHERE (s.id = :id)"
//    )
//    List<String> getAllInterviewerNameById (Integer id);
}
