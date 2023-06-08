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
        "rentedOut"
})
@ToString(exclude = {
        "rentedOut"
})
@Table(name = "tariff")
@Entity
public class HiberTariff {

    @Id
    @GeneratedValue(generator = "tariff_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "tariff_id_seq", sequenceName = "tariff_id_seq", allocationSize = 1, initialValue = 100)
    private Long id;

    @Column(name = "tariff_name")
    private String tariffName;

    @Column(name = "rent_price")
    private Long rentPrice;

    @Column
    private Timestamp created;

    @Column
    private Timestamp changed;

    //@ManyToOne
    //@JoinColumn(name = "rented_out_id")
    //@JsonBackReference
    //private HiberRentedOut rentedOut;

     @OneToMany(mappedBy = "tariff", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = false)
     @JsonManagedReference
     private Set<HiberRentedOut> rentedOuts = Collections.emptySet();


}
