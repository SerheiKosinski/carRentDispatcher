package by.remprofi.domain.hiber;

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
import javax.persistence.OneToMany;
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
        "users" , "car" , "tariffs"
})
@ToString(exclude = {
        "users " , "car", "tariffs"
})
@Table(name = "rented_out")
@Entity
public class HiberRentedOut {

    @Id
    @GeneratedValue(generator = "rented_out_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "rented_out_id_seq", sequenceName = "rented_out_id_seq", allocationSize = 1, initialValue = 100)
    private Long id;

    @Column
    private Timestamp rent;

    @Column(name = "return")
    private Timestamp  returns;

    @Column(name = "car_id")
    private Long carId;

    @Column(name = "user_id")
    private Long usersId;

    @Column(name = "tariff_id")
    private Long tariffId;

    @Column
    private Timestamp created;

    @Column
    private Timestamp changed;

    @OneToMany(mappedBy = "rented_out", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = false)
    @JsonManagedReference
    private Set<HiberUser> users = Collections.emptySet();

    @OneToMany(mappedBy = "rented_out", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = false)
    @JsonManagedReference
    private Set<HiberTariff> tariffs = Collections.emptySet();

    @OneToOne(mappedBy = "rented_out" , cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = false)
    @JsonManagedReference
    private HiberCar car;
}
