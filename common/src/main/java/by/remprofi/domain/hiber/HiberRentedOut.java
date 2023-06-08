package by.remprofi.domain.hiber;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@EqualsAndHashCode(exclude = {
        "users" , "car" , "tariff"
})
@ToString(exclude = {
        "users " , "car", "tariff"
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

    @Column
    private Long carId;

    @Column
    private Long usersId;

    @Column
    private Long tariffId;

    @Column
    private Timestamp created;

    @Column
    private Timestamp changed;

    ///@OneToMany(mappedBy = "rented_out", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = false)
    ///@JsonManagedReference
    ///private Set<HiberUser> users = Collections.emptySet();

   // @OneToMany(mappedBy = "rented_out", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = false)
   // @JsonManagedReference
   // private Set<HiberTariff> tariff = Collections.emptySet();

   // @OneToOne(mappedBy = "rented_out" , cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = false)
   // @JsonManagedReference
   // private HiberCar car;

     @OneToOne
     @JoinColumn(name = "car_id")
     @JsonBackReference
     private HiberCar car;

    @ManyToOne
    @JoinColumn(name = "tariff_id")
    @JsonBackReference
    private HiberTariff tariff;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private HiberUser user;

}
