package fa.training.fjb04.ims.controller.job;

import fa.training.fjb04.ims.dto.JobDto;
import fa.training.fjb04.ims.entity.Job;
import fa.training.fjb04.ims.enums.Status;
import fa.training.fjb04.ims.service.JobService;
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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/job")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("jobDtoList", jobService.showAll());

        return "jobs/list_job";
    }

    @GetMapping("/api/v1")
    @ResponseBody
    public ResponseEntity<Page<JobDto>> searchCandidateList(
            @RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false, value = "pageIndex") int pageIndex,
            @RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false, value = "pageSize") int pageSize,
            @RequestParam(required = false, value = "keyword") String keyword,
            @RequestParam(required = false, value = "status") String status) {

        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        Page<JobDto> jobDtoPage = jobService.searchJobList(keyword, status, pageable);

        return new ResponseEntity<>(jobDtoPage, HttpStatus.OK);
    }
}
