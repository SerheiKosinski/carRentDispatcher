package by.remprofi.domain.hibernate;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HiberRentedOut.class)
public abstract class HiberRentedOut_ {

	public static volatile SingularAttribute<HiberRentedOut, Timestamp> created;
	public static volatile SingularAttribute<HiberRentedOut, Long> usersId;
	public static volatile SingularAttribute<HiberRentedOut, Timestamp> returns;
	public static volatile SingularAttribute<HiberRentedOut, Long> id;
	public static volatile SingularAttribute<HiberRentedOut, Long> tariffId;
	public static volatile SingularAttribute<HiberRentedOut, Timestamp> rent;
	public static volatile SingularAttribute<HiberRentedOut, Long> carId;
	public static volatile SingularAttribute<HiberRentedOut, Timestamp> changed;

	public static final String CREATED = "created";
	public static final String USERS_ID = "usersId";
	public static final String RETURNS = "returns";
	public static final String ID = "id";
	public static final String TARIFF_ID = "tariffId";
	public static final String RENT = "rent";
	public static final String CAR_ID = "carId";
	public static final String CHANGED = "changed";

}

