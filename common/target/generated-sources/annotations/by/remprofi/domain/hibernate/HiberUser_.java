package by.remprofi.domain.hibernate;

import by.remprofi.domain.Violations;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HiberUser.class)
public abstract class HiberUser_ {

	public static volatile SingularAttribute<HiberUser, Long> passportNumber;
	public static volatile SingularAttribute<HiberUser, String> passportSerial;
	public static volatile SingularAttribute<HiberUser, AuthenticationInfo> authenticationInfo;
	public static volatile SingularAttribute<HiberUser, String> surname;
	public static volatile SingularAttribute<HiberUser, Long> drivingLicense;
	public static volatile SingularAttribute<HiberUser, Violations> violations;
	public static volatile SingularAttribute<HiberUser, String> name;
	public static volatile SingularAttribute<HiberUser, Double> rating;
	public static volatile SingularAttribute<HiberUser, String> fullName;
	public static volatile SingularAttribute<HiberUser, Long> id;
	public static volatile SingularAttribute<HiberUser, Timestamp> birthDate;

	public static final String PASSPORT_NUMBER = "passportNumber";
	public static final String PASSPORT_SERIAL = "passportSerial";
	public static final String AUTHENTICATION_INFO = "authenticationInfo";
	public static final String SURNAME = "surname";
	public static final String DRIVING_LICENSE = "drivingLicense";
	public static final String VIOLATIONS = "violations";
	public static final String NAME = "name";
	public static final String RATING = "rating";
	public static final String FULL_NAME = "fullName";
	public static final String ID = "id";
	public static final String BIRTH_DATE = "birthDate";

}

