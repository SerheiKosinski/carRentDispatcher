package by.remprofi.domain.hibernate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "tehnical_inspection")
public class HiberTehnicalInspection {

    @Id
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

}
