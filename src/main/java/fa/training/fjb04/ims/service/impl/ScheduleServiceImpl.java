package fa.training.fjb04.ims.service.impl;

import fa.training.fjb04.ims.dto.ScheduleDto;
import fa.training.fjb04.ims.entity.Schedule;
import fa.training.fjb04.ims.enums.Status;
import fa.training.fjb04.ims.enums.StatusSchedule;
import fa.training.fjb04.ims.repository.ScheduleRepository;
import fa.training.fjb04.ims.repository.UserRepository;
import fa.training.fjb04.ims.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    @Override
    public Page<ScheduleDto> searchScheduleList (String keyword, String interviewer, StatusSchedule statusSchedule, Pageable pageable) {

        Page<Schedule> schedulePage = scheduleRepository.searchScheduleList(keyword, interviewer, statusSchedule, pageable);
        return schedulePage.map(sch -> new ScheduleDto(sch.getId(), sch.getTitle()
                                                        , sch.getCandidate()
                                                        , sch.getMainInterviewer() != null ? sch.getMainInterviewer().getFullName() : "null"
                                                        , userRepository.getAllNameByScheduleId(sch.getId())
                                                        , sch.getScheduleDate()
                                                        , sch.getScheduleTimeFrom()
                                                        , sch.getScheduleTimeTo()
                                                        , sch.getResult().getName()
                                                        , sch.getStatusSchedule().getName()
                                                        , sch.getJob().getTitle()));
    }
}
