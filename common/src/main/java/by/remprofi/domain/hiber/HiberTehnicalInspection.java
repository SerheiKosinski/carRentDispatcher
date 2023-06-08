package by.remprofi.domain.hiber;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
        "employees"
})
@ToString(exclude = {
        "employees"
})
@Table(name = "tehnical_inspection")
@Entity
public class HiberTehnicalInspection {

    @Id
    @GeneratedValue(generator = "tehnical_inspection_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "tehnical_inspection_id_seq", sequenceName = "tehnical_inspection_id_seq", allocationSize = 1, initialValue = 100)
    private Long id;

    @Column
    private Long mileage;

    @Column
    private String maintenance;

    @Column(name = "fuel_level")
    private Long fuelLevel;

    @Column(name = "under_repair")
    private String underRepair;

    @Column
    private Timestamp create;

    @Column
    private Timestamp changed;

    @ManyToMany(mappedBy = "tehnical_inspection", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("employees")
    private Set<HiberEmployees> employees = Collections.emptySet();

    @OneToOne
    @JoinColumn(name = "car_id")
    @JsonBackReference
    private HiberCar car;

    ///@ManyToMany
    ///@JoinTable(name = "l_employees_tehnikal_inspection",
    ///        joinColumns = @JoinColumn(name = "tehnical_inspection_id"),
    ///        inverseJoinColumns = @JoinColumn(name = "employees_id")
   /// )
    ///@JsonIgnoreProperties("tehnical_inspection")
    ///private Set<HiberEmployees> employees = Collections.emptySet();


}
