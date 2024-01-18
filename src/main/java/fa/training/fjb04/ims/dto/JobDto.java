package fa.training.fjb04.ims.dto;

import fa.training.fjb04.ims.entity.common.Level;
import fa.training.fjb04.ims.entity.common.Skills;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class JobDto {
    private Integer jobId;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Skills> skillsList;
    private List<Level> levelList;
    private String status;

    public JobDto(Integer jobId, String title, LocalDate startDate, LocalDate endDate, List<Skills> skillsList, List<Level> levelList, String status) {
        this.jobId = jobId;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.skillsList = skillsList;
        this.levelList = levelList;
        this.status = status;
    }
}
