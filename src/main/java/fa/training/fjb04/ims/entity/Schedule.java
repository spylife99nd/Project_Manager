package fa.training.fjb04.ims.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fa.training.fjb04.ims.entity.intermediateTable.UserSchedule;
import fa.training.fjb04.ims.enums.Result;
import fa.training.fjb04.ims.enums.StatusSchedule;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Integer id;

    @Column(name = "title", nullable = false)
    @NotBlank(message = "Title can not be empty")
    private String title;

    @OneToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @Column(name = "schedule_date")
    private LocalDate scheduleDate;

    @Column(name = "schedule_time_from")
    private LocalTime scheduleTimeFrom;

    @Column(name = "schedule_time_to")
    private LocalTime scheduleTimeTo;

    @Column(name = "note", length = 500)
    @NotBlank(message = "Note can not be empty")
    private String note;

    @Column(name = "location")
    @NotBlank(message = "Location can not be empty")
    private String location;

    @Column(name = "meeting_id")
    @NotBlank(message = "Meeting id can not be empty")
    private String meetingId;

    @ManyToOne
    @JoinColumn(name = "recruiter_owner")
    private User recruiter;

    @ManyToOne
    @JoinColumn(name = "main_interviewer")
    private User mainInterviewer;

    @OneToMany(mappedBy = "schedule")
    @JsonIgnore
    private List<UserSchedule> userScheduleList = new ArrayList<>();

    @ManyToOne
    @JoinColumn (name = "job_id")
    private Job job;

    @OneToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    @Column(name = "result")
    @NotBlank(message = "Result can not be empty")
    private Result result;

    @Column(name = "status")
    @NotBlank(message = "Result can not be empty")
    private StatusSchedule statusSchedule;
}
