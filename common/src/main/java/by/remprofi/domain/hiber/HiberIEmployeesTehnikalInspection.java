package by.remprofi.domain.hiber;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "i_employees_tehnikal_inspection")
public class HiberIEmployeesTehnikalInspection {

    @Id
    @GeneratedValue(generator = "i_employees_tehnikal_inspection_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "i_employees_tehnikal_inspection_id_seq", sequenceName = "i_employees_tehnikal_inspection_id_seq", allocationSize = 1, initialValue = 100)

    private Long id;

    @Column(name = "technical_inspection_id")
    private Long technicalInspectionId;

    @Column
    private Timestamp created;

    @Column
    private Timestamp changed;

    @Column
    private Long employeesId;

}
