package fa.training.fjb04.ims.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fa.training.fjb04.ims.entity.common.HighLevel;
import fa.training.fjb04.ims.entity.intermediateTable.CandidateSkill;
import fa.training.fjb04.ims.enums.Gender;
import fa.training.fjb04.ims.enums.Position;
import fa.training.fjb04.ims.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Table
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate extends AbstractAuditingEntity {
    @Id
    @Column(name = "candidate_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer candidateId;

    @Column(name = "full_name", nullable = false)
    @NotBlank(message = "FullName can not be empty")
    private String fullName;

    @Column(name = "email", nullable = false, unique = true)
    @NotBlank(message = "Email can not be empty")
    private String email;

    @Column(name = "phone_number", nullable = false, unique = true)
    @NotBlank(message = "PhoneNumber can not be empty")
    private String phoneNumber;

    @Column(name = "date_of_birth", nullable = false)
    @NotNull(message = "DateOfBirth can not be empty")
    private LocalDate dateOfBirth;

    @Column(name = "address", nullable = false)
    @NotBlank(message = "Address can not be empty")
    private String address;

    @Column(name = "current_position", nullable = false)
    @NotNull(message = "Position can not be empty")
    private Position position;

    @Column(name = "gender")
    @NotBlank(message = "Gender can not be empty")
    private Gender gender;

    @Column(name = "CV_Attachment")
    private String cvAttachment;

    @Column(name = "note", length = 500)
    @NotBlank(message = "Note can not be empty")
    private String note;

    @Column(name = "status")
    @NotNull(message = "Status can not be empty")
    private Status status;

    @Column(name = "year_of_experience")
    @NotNull(message = "YearOfExperience can not be empty")
    private Integer yearOfExperience;

    @ManyToOne
    @JoinColumn(name = "high_level_id")
    @NotNull(message = "HighLevel can not be empty")
    @JsonIgnore
    private HighLevel highLevel;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotBlank(message = "FullName can not be empty")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "candidate")
    @JsonIgnore
    private List<CandidateSkill> candidateSkillList = new ArrayList<>();

    @OneToOne(mappedBy = "candidate")
    @JsonIgnore
    private Offer offer;

    @OneToOne(mappedBy = "candidate")
    @JsonIgnore
    private Schedule schedule;
}
