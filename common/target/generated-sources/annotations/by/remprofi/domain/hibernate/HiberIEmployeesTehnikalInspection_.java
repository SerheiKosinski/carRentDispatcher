package by.remprofi.domain.hibernate;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HiberIEmployeesTehnikalInspection.class)
public abstract class HiberIEmployeesTehnikalInspection_ {

	public static volatile SingularAttribute<HiberIEmployeesTehnikalInspection, Timestamp> created;
	public static volatile SingularAttribute<HiberIEmployeesTehnikalInspection, Long> technicalInspectionId;
	public static volatile SingularAttribute<HiberIEmployeesTehnikalInspection, Long> id;
	public static volatile SingularAttribute<HiberIEmployeesTehnikalInspection, Long> employeesId;
	public static volatile SingularAttribute<HiberIEmployeesTehnikalInspection, Timestamp> changed;

	public static final String CREATED = "created";
	public static final String TECHNICAL_INSPECTION_ID = "technicalInspectionId";
	public static final String ID = "id";
	public static final String EMPLOYEES_ID = "employeesId";
	public static final String CHANGED = "changed";

}

