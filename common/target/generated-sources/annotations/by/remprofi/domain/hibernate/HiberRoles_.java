package by.remprofi.domain.hibernate;

import by.remprofi.domain.SystemRoles;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HiberRoles.class)
public abstract class HiberRoles_ {

	public static volatile SingularAttribute<HiberRoles, SystemRoles> systemRole;
	public static volatile SingularAttribute<HiberRoles, Timestamp> created;
	public static volatile SingularAttribute<HiberRoles, Long> id;
	public static volatile SingularAttribute<HiberRoles, Long> userId;
	public static volatile SingularAttribute<HiberRoles, Timestamp> changed;

	public static final String SYSTEM_ROLE = "systemRole";
	public static final String CREATED = "created";
	public static final String ID = "id";
	public static final String USER_ID = "userId";
	public static final String CHANGED = "changed";

}

