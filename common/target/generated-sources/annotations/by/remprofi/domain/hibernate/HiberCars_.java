package by.remprofi.domain.hibernate;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HiberCars.class)
public abstract class HiberCars_ {

	public static volatile SingularAttribute<HiberCars, Long> technical_inspection_id;
	public static volatile SingularAttribute<HiberCars, Boolean> deleted;
	public static volatile SingularAttribute<HiberCars, Timestamp> created;
	public static volatile SingularAttribute<HiberCars, String> model;
	public static volatile SingularAttribute<HiberCars, Long> id;
	public static volatile SingularAttribute<HiberCars, String> brand;
	public static volatile SingularAttribute<HiberCars, HiberUser> user;
	public static volatile SingularAttribute<HiberCars, Long> mileage;
	public static volatile SingularAttribute<HiberCars, String> car_body;
	public static volatile SingularAttribute<HiberCars, Timestamp> changed;

	public static final String TECHNICAL_INSPECTION_ID = "technical_inspection_id";
	public static final String DELETED = "deleted";
	public static final String CREATED = "created";
	public static final String MODEL = "model";
	public static final String ID = "id";
	public static final String BRAND = "brand";
	public static final String USER = "user";
	public static final String MILEAGE = "mileage";
	public static final String CAR_BODY = "car_body";
	public static final String CHANGED = "changed";

}

