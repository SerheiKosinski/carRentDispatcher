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
@Table(name = "tariff")
public class HiberTariff {

    @Id
    private Long id;

    @Column(name = "tariff_name")
    private String tariffName;

    @Column(name = "rent_price")
    private Long rentPrice;

    @Column
    private Timestamp created;

    @Column
    private Timestamp changed;

}
