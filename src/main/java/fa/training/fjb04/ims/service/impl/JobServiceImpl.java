package fa.training.fjb04.ims.service.impl;

import fa.training.fjb04.ims.dto.JobDto;
import fa.training.fjb04.ims.entity.Job;
import fa.training.fjb04.ims.enums.Status;
import fa.training.fjb04.ims.repository.JobRepository;
import fa.training.fjb04.ims.repository.LevelRepository;
import fa.training.fjb04.ims.repository.SkillRepository;
import fa.training.fjb04.ims.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    private final SkillRepository skillRepository;

    private final LevelRepository levelRepository;

    @Override
    public List<Job> getAll() {
        return jobRepository.findAll();
    }

    @Override
    public void create(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Optional<Job> findById(Integer id) {
        return jobRepository.findById(id);
    }

    @Override
    public void update(Integer id) {

    }

    @Override
    public void delete(Integer id) {
        jobRepository.deleteById(id);
    }

    @Override
    public Page<JobDto> searchJobList(String keyword, String status, Pageable pageable) {
        Page<Job> jobPage = jobRepository.getSearchList(keyword, status, pageable);

        return jobPage.map(j -> new JobDto(j.getId(), j.getTitle(),
                j.getStartDate(), j.getEndDate(), skillRepository.getAllByJobId(j.getId()),
                levelRepository.getAllByJobId(j.getId()), j.getStatus()));
    }

    @Override
    public List<JobDto> showAll() {
        List<Job> jobList = jobRepository.findAll();
        List<JobDto> jobDtoList = new ArrayList<>();

        for (Job job : jobList) {
            JobDto jobDto = JobDto.builder()
                    .jobId(job.getId())
                    .title(job.getTitle())
                    .startDate(job.getStartDate())
                    .endDate(job.getEndDate())
                    .skillsList(skillRepository.getAllByJobId(job.getId()))
                    .levelList(levelRepository.getAllByJobId(job.getId()))
                    .status(job.getStatus())
                    .build();

            jobDtoList.add(jobDto);
        }

        return jobDtoList;
    }

}
