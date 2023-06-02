package by.remprofi.domain.hibernate;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HiberICarPark.class)
public abstract class HiberICarPark_ {

	public static volatile SingularAttribute<HiberICarPark, Timestamp> created;
	public static volatile SingularAttribute<HiberICarPark, Long> id;
	public static volatile SingularAttribute<HiberICarPark, Long> parkId;
	public static volatile SingularAttribute<HiberICarPark, Long> carId;
	public static volatile SingularAttribute<HiberICarPark, Timestamp> changed;

	public static final String CREATED = "created";
	public static final String ID = "id";
	public static final String PARK_ID = "parkId";
	public static final String CAR_ID = "carId";
	public static final String CHANGED = "changed";

}

