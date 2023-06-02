package by.remprofi.domain.hibernate;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HiberTehnicalInspection.class)
public abstract class HiberTehnicalInspection_ {

	public static volatile SingularAttribute<HiberTehnicalInspection, Long> fuelLevel;
	public static volatile SingularAttribute<HiberTehnicalInspection, String> underRepair;
	public static volatile SingularAttribute<HiberTehnicalInspection, Timestamp> create;
	public static volatile SingularAttribute<HiberTehnicalInspection, Long> id;
	public static volatile SingularAttribute<HiberTehnicalInspection, String> maintenance;
	public static volatile SingularAttribute<HiberTehnicalInspection, Long> mileage;
	public static volatile SingularAttribute<HiberTehnicalInspection, Timestamp> changed;

	public static final String FUEL_LEVEL = "fuelLevel";
	public static final String UNDER_REPAIR = "underRepair";
	public static final String CREATE = "create";
	public static final String ID = "id";
	public static final String MAINTENANCE = "maintenance";
	public static final String MILEAGE = "mileage";
	public static final String CHANGED = "changed";

}

