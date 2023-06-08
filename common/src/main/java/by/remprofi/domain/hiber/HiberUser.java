package by.remprofi.domain.hiber;

import by.remprofi.domain.Violations;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@EqualsAndHashCode(exclude = {
        "roles" , "rented_out"
})
@ToString(exclude = {
        "roles" , "rented_out "
})
@Entity
@Table(name = "users")
public class HiberUser {

    @Id
    @GeneratedValue(generator = "users_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1, initialValue = 100)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column
    private String surname;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column
    private Double rating;

    @Column(name = "passport_number")
    private Long passportNumber;

    @Column(name = "passport_serial")
    private String passportSerial;

    @Column(name = "driving_license")
    private Long drivingLicense;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "email", column = @Column(name = "email")),
            @AttributeOverride(name = "password", column = @Column(name = "user_password"))
    })
    private AuthenticationInfo authenticationInfo;

    @Column(name = "violations")
    @Enumerated(EnumType.STRING)
    private Violations violations = Violations.NOT_SELECTED;


     @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = false)
     @JsonManagedReference
    private Set<HiberRoles> roles = Collections.emptySet();

    ///@ManyToOne
    ///@JoinColumn(name = "rented_out_id")
    ///@JsonBackReference
    ///private HiberRentedOut rentedOut;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = false)
    @JsonManagedReference
    private Set<HiberRentedOut> rentedOuts = Collections.emptySet();


}
