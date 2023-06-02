package by.remprofi.domain.hibernate;

import by.remprofi.domain.SystemRoles;
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
@Table(name = "roles")
public class HiberRoles {

    @Id
    private Long id;

    @Column
    private SystemRoles systemRole = SystemRoles.ROLE_USER;

    @Column(name = "user_id")
    private Long userId;

    @Column
    private Timestamp created;

    @Column
    private Timestamp changed;


}
