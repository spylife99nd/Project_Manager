package fa.training.fjb04.ims.service;

import fa.training.fjb04.ims.dto.JobDto;
import fa.training.fjb04.ims.entity.Job;
import fa.training.fjb04.ims.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface JobService {
    List<Job> getAll();

    void create(Job job);

    Optional<Job> findById(Integer id);

    void update(Integer id);

    void delete(Integer id);

    Page<JobDto> searchJobList(String keyword, String status, Pageable pageable);

    List<JobDto> showAll();
}
