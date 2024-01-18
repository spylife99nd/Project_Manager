package fa.training.fjb04.ims.entity.intermediateTable;

import fa.training.fjb04.ims.entity.Candidate;
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
public class CandidateSkill {
    @Id
    @Column(name = "candidate_skill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skills skill;
}
