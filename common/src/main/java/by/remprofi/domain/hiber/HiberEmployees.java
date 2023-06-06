package by.remprofi.domain.hiber;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@EqualsAndHashCode(exclude = {
        "tehnicalInspection"
})
@ToString(exclude = {
        "tehnicalInspection"
})
@Entity
@Table(name ="employees")
public class HiberEmployees {

    @Id
    @GeneratedValue(generator = "employees_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "employees_id_seq", sequenceName = "employees_id_seq",
            allocationSize = 1, initialValue = 100)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column(name = "job_title")
    private String jobTitle;

    @Column
    private Timestamp created;

    @Column
    private Timestamp changed;

    @ManyToMany
    @JoinTable(name = "i_employees_tehnikal_inspection",
            joinColumns = @JoinColumn(name = "employees_id"),
            inverseJoinColumns = @JoinColumn(name = "tehnical_inspection_id")
    )
    @JsonIgnoreProperties("employees")
    private Set<HiberTehnicalInspection> tehnicalInspection = Collections.emptySet();

}
