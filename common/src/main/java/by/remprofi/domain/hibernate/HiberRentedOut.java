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
@Table(name = "rented_out")
public class HiberRentedOut {

    @Id
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

}
