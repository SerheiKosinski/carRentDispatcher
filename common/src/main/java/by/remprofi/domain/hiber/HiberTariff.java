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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.sql.Timestamp;

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

    @ManyToOne
    @JoinColumn(name = "rented_out")
    @JsonBackReference
    private HiberRentedOut rentedOut;

}
