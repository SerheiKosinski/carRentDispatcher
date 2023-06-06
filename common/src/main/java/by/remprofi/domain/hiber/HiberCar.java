package by.remprofi.domain.hiber;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
import javax.persistence.JoinTable;
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
        "park" , "rentedOut"
})
@ToString(exclude = {
        "park" , "rentedOut"
})
@Table(name = "car")
@Entity
public class HiberCar {

    @Id
    @GeneratedValue(generator = "car_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "car_id_seq", sequenceName = "car_id_seq", allocationSize = 1, initialValue = 100)
    private Long id;

    @Column
    private String brand;

    @Column
    private Long mileage;

    @Column
    private String car_body;

    @Column
    private String model;

    @Column
    private Timestamp created;

    @Column
    private Timestamp changed;

    @Column
    private Long technical_inspection_id;


    @Column(name = "is_deleted")
    private Boolean deleted;

    @ManyToMany
    @JoinTable(name = "I_car_park",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "park_id")
    )
    @JsonIgnoreProperties("car")
    private Set<HiberPark> park = Collections.emptySet();

    @OneToOne
    @JoinColumn(name = "rented_out")
    @JsonBackReference
    private HiberRentedOut rentedOut;

    @OneToOne(mappedBy = "car" , cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = false)
    @JsonManagedReference
    private HiberTehnicalInspection tehnicalInspection;

}
