package fa.training.fjb04.ims.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fa.training.fjb04.ims.entity.intermediateTable.UserSchedule;
import fa.training.fjb04.ims.enums.Department;
import fa.training.fjb04.ims.enums.Gender;
import fa.training.fjb04.ims.enums.Roles;
import fa.training.fjb04.ims.enums.Status;
import fa.training.fjb04.ims.enums.UserStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Table
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractAuditingEntity {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "full_name", nullable = false)
    @NotBlank(message = "FullName can not be empty")
    private String fullName;

    @Column(name = "user_name", nullable = false)
    @NotBlank(message = "UserName can not be empty")
    private String userName;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "Password can not be empty")
    private String password;

    @Column(name = "date_of_birth", nullable = false)
    @NotNull(message = "DateOfBirth can not be null")
    private LocalDate dateOfBirth;

    @Column(name = "phone_number", nullable = false)
    @NotBlank(message = "PhoneNumber can not be empty")
    private String phoneNumber;

    @Column(name = "role")
    @NotNull(message = "Role can not be empty")
    private Roles role;

    @Column(name = "status")
    @NotNull(message = "Status can not be empty")
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(name = "email", nullable = false, unique = true)
    @NotBlank(message = "Email can not be empty")
    private String email;

    @Column(name = "address", nullable = false)
    @NotBlank(message = "Address can not be empty")
    private String address;

    @Column(name = "gender")
    @NotNull(message = "Gender can not be empty")
    private Gender gender;

    @Column(name = "department")
    @NotNull(message = "Department can not be empty")
    private Department department;

    @Column(name = "note")
    private String note;

    @Column(name = "reset_token")
    private String resetToken;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Candidate> candidateList = new ArrayList<>();

    @OneToMany(mappedBy = "approver")
    @JsonIgnore
    private List<Offer> offerList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<UserSchedule> userScheduleList = new ArrayList<>();

    @OneToMany(mappedBy = "recruiter")
    @JsonIgnore
    private List<Schedule> schedulesRecruiter = new ArrayList<>();

    @OneToMany(mappedBy = "mainInterviewer")
    @JsonIgnore
    private List<Schedule> schedulesMItvw = new ArrayList<>();
}