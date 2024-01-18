package fa.training.fjb04.ims.entity.intermediateTable;

import fa.training.fjb04.ims.entity.Job;
import fa.training.fjb04.ims.entity.common.Skills;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSkill {
    @Id
    @Column(name = "job_skill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skills skills;
}

