package info.forallactivities;

import java.util.List;
import java.util.Properties;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddController {
	@RequestMapping(value = "/make", method = RequestMethod.POST)
	public @ResponseBody List<News> make(@RequestBody Search search) {
		
		Properties prop = new Properties();
		prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		prop.setProperty("hibernate.connection.url", "jdbc:mysql://172.30.234.118:3306/workspace");
		prop.setProperty("hibernate.connection.username", "userhKP");
		prop.setProperty("hibernate.connection.password", "ILweMo3x");
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		prop.setProperty("hbm2ddl.auto", "update");
		
		
		System.out.println(search.getId());
		Configuration conf = new Configuration().addProperties(prop).addAnnotatedClass(News.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
		SessionFactory sf = conf.buildSessionFactory(reg);
		Session session = sf.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();

		CriteriaQuery<News> criteria = cb.createQuery(News.class);
		Root<News> contactRoot = criteria.from(News.class);
		criteria.orderBy(cb.desc(contactRoot.get(News_.date)));
		if (search.getId() == 0) {
		} else {
			Predicate p1 = cb.lessThan(contactRoot.get(News_.nid), search.getId());
			criteria.where(p1);
		}
		criteria.select(contactRoot);
		List<News> news = session.createQuery(criteria).setMaxResults(2).getResultList();
		session.close();
		sf.close();
		reg.close();
		return news;
	}
}
