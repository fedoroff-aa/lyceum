package info.forallactivities;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {
	@RequestMapping(value = "/make", method = RequestMethod.POST)
	public @ResponseBody List<News> make(@RequestBody Search search) {
		System.out.println(search.getId());

		Configuration conf = new Configuration().configure("/resources/hibernate.cfg.xml").addAnnotatedClass(News.class);
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
