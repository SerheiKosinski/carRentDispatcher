package by.remprofi.domain.hibernate;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HiberPark.class)
public abstract class HiberPark_ {

	public static volatile SingularAttribute<HiberPark, String> city;
	public static volatile SingularAttribute<HiberPark, Timestamp> created;
	public static volatile SingularAttribute<HiberPark, Long> id;
	public static volatile SingularAttribute<HiberPark, Long> parkNumber;
	public static volatile SingularAttribute<HiberPark, Timestamp> changed;

	public static final String CITY = "city";
	public static final String CREATED = "created";
	public static final String ID = "id";
	public static final String PARK_NUMBER = "parkNumber";
	public static final String CHANGED = "changed";

}

