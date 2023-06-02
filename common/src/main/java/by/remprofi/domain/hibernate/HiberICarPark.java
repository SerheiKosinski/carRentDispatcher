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
@Table(name = "i_car_park")

public class HiberICarPark {

    @Id
    private Long id;

    @Column(name = "car_id")
    private Long carId;

    @Column(name = "park_id")
    private Long parkId;

    @Column
    private Timestamp created;

    @Column
    private Timestamp changed;



}
