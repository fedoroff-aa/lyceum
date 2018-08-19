package info.forallactivities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(News.class)
public abstract class News_ {
	public static volatile SingularAttribute<News, Integer> nid;
	public static volatile SingularAttribute<News, String> header;
	public static volatile SingularAttribute<News, String> text;
	public static volatile SingularAttribute<News, String> date;

}
