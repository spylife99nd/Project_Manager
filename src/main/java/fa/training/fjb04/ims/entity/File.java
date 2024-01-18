package fa.training.fjb04.ims.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Table
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class File extends AbstractAuditingEntity {
    @Id
    @Column(name = "file_id")
    private Integer id;

    @Column(name = "file_name")
    private String name;

    @Column(name = "file_url")
    private String url;
}
