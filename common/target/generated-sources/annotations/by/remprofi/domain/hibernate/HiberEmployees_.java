package by.remprofi.domain.hibernate;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HiberEmployees.class)
public abstract class HiberEmployees_ {

	public static volatile SingularAttribute<HiberEmployees, String> surname;
	public static volatile SingularAttribute<HiberEmployees, Timestamp> created;
	public static volatile SingularAttribute<HiberEmployees, String> jobTitle;
	public static volatile SingularAttribute<HiberEmployees, String> name;
	public static volatile SingularAttribute<HiberEmployees, Long> id;
	public static volatile SingularAttribute<HiberEmployees, Timestamp> changed;

	public static final String SURNAME = "surname";
	public static final String CREATED = "created";
	public static final String JOB_TITLE = "jobTitle";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String CHANGED = "changed";

}

