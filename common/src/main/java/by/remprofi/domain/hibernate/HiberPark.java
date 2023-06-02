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
@Table(name = "park")
public class HiberPark {

    @Id
    private Long id;

    @Column(name = "park_number")
    private Long parkNumber;

    @Column
    private Timestamp created;

    @Column
    private Timestamp changed;

    @Column
    private String city;

}
