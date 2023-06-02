package by.remprofi.domain.hibernate;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HiberTariff.class)
public abstract class HiberTariff_ {

	public static volatile SingularAttribute<HiberTariff, String> tariffName;
	public static volatile SingularAttribute<HiberTariff, Timestamp> created;
	public static volatile SingularAttribute<HiberTariff, Long> id;
	public static volatile SingularAttribute<HiberTariff, Long> rentPrice;
	public static volatile SingularAttribute<HiberTariff, Timestamp> changed;

	public static final String TARIFF_NAME = "tariffName";
	public static final String CREATED = "created";
	public static final String ID = "id";
	public static final String RENT_PRICE = "rentPrice";
	public static final String CHANGED = "changed";

}

