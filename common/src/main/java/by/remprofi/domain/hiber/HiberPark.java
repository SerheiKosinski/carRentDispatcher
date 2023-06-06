package by.remprofi.domain.hiber;

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
        "car"
})
@ToString(exclude = {
        "car"
})
@Table(name = "park")
@Entity
public class HiberPark {

    @Id
    @GeneratedValue(generator = "park_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "park_id_seq", sequenceName = "park_id_seq", allocationSize = 1, initialValue = 100)
    private Long id;

    @Column(name = "park_number")
    private Long parkNumber;

    @Column
    private Timestamp created;

    @Column
    private Timestamp changed;

    @Column
    private String city;

    @ManyToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("park")
    private Set<HiberCar> car = Collections.emptySet();

}
