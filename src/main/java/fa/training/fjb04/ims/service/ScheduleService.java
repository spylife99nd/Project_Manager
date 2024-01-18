package fa.training.fjb04.ims.service;

import fa.training.fjb04.ims.dto.ScheduleDto;
import fa.training.fjb04.ims.enums.Status;
import fa.training.fjb04.ims.enums.StatusSchedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface ScheduleService {

    Page<ScheduleDto> searchScheduleList (String keyword, String interviewer, StatusSchedule statusSchedule, Pageable pageable);
}
