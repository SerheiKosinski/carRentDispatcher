package by.remprofi.domain.hiber;

import by.remprofi.domain.SystemRoles;
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
        "users"
})
@ToString(exclude = {
        "users"
})
@Entity
@Table(name = "roles")
public class HiberRoles {

    @Id
    @GeneratedValue(generator = "roles_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "roles_id_seq", sequenceName = "roles_id_seq", allocationSize = 1, initialValue = 100)
    private Long id;

    @Column
    private SystemRoles systemRole = SystemRoles.ROLE_USER;

    @Column(name = "user_id")
    private Long userId;

    @Column
    private Timestamp created;

    @Column
    private Timestamp changed;

    @ManyToOne
    @JoinColumn(name = "users_id")
    @JsonBackReference
    private HiberUser users;

}
