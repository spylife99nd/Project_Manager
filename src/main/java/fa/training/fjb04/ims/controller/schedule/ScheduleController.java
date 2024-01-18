package fa.training.fjb04.ims.controller.schedule;

import fa.training.fjb04.ims.dto.ScheduleDto;
import fa.training.fjb04.ims.enums.StatusSchedule;
import fa.training.fjb04.ims.service.ScheduleService;
import fa.training.fjb04.ims.service.UserService;
import fa.training.fjb04.ims.util.constant.AppConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final UserService userService;

    @GetMapping
    public String showScheduleTable (Model model) {

        model.addAttribute("interviewerList", userService.getAllName());

        return "schedule/schedule_list";
    }

    @GetMapping("/api/v1")
    @ResponseBody
    public ResponseEntity<Page<ScheduleDto>> searchScheduleTable (
            @RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false, value = "pageIndex") int pageIndex
            ,@RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false, value = "pageSize") int pageSize
            ,@RequestParam(required = false, value = "keyword") String keyword
            ,@RequestParam(required = false, value = "interviewer") String interviewer
            ,@RequestParam(required = false, value = "status") String status) {

        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        StatusSchedule statusSchedule = (status != null) ? StatusSchedule.valueOf(status) : null;
        Page<ScheduleDto> scheduleDtoPage = scheduleService.searchScheduleList(keyword, interviewer, statusSchedule, pageable);

        return new ResponseEntity<>(scheduleDtoPage, HttpStatus.OK);
    }
}
