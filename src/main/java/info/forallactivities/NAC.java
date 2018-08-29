package info.forallactivities;

import java.io.File;
import java.util.List;
import java.util.Properties;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import info.forallactivities.sql_tables.AddArticle;
import info.forallactivities.sql_tables.Menu_item;
import info.forallactivities.sql_tables.News;
import info.forallactivities.sql_tables.NewsRMs;
import info.forallactivities.sql_tables.News_;
import info.forallactivities.sql_tables.Search;
import info.forallactivities.sql_tables.Users;
import info.forallactivities.sql_tables.Users_;

//News And Articles Controller
@Controller
@SessionAttributes(value = "user")
public class NAC {
	
	/*	
	 * 	ARTICLE CONTROLLERS
	 */
	@RequestMapping(value = "/add_article", method = RequestMethod.POST)
	public @ResponseBody String add_article(@RequestBody AddArticle aa, HttpServletRequest h) {
		try {
			File f = new File(h.getSession().getServletContext().getRealPath("/pages/articles"), aa.getPagename());
			FileUtils.writeStringToFile(f, aa.getPagecontent());
		} catch (Exception e) {e.printStackTrace();}
		return "";
		
	}
	
	/*	
	 * 	NEWS CONTROLLERS
	 */
	
	public News getNewsItem(long nid) {
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(forworkspace_conf(News.class).getProperties()).build();
		SessionFactory sf = forworkspace_conf(News.class).buildSessionFactory(reg);
		Session session = sf.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();

		CriteriaQuery<News> criteria = cb.createQuery(News.class);
		Root<News> contactRoot = criteria.from(News.class);
		
		Predicate p1 = cb.equal(contactRoot.get(News_.nid), nid);
		criteria.where(p1);
		criteria.select(contactRoot);
		News n = session.createQuery(criteria).getSingleResult();
		session.close();
		sf.close();
		reg.close();
		return n;
	}
	// n = news
	
	@RequestMapping(value="/menu_items", method=RequestMethod.POST)
	public @ResponseBody List<Menu_item> menu_items(){
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(forworkspace_conf(Menu_item.class).getProperties()).build();
		SessionFactory sf = forworkspace_conf(Menu_item.class).buildSessionFactory(reg);
		Session session = sf.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		CriteriaQuery<Menu_item> criteria = cb.createQuery(Menu_item.class);
		Root<Menu_item> contactRoot = criteria.from(Menu_item.class);
		criteria.select(contactRoot);
		List<Menu_item> menu_items = session.createQuery(criteria).getResultList();
		
		session.close();
		sf.close();
		reg.close();
		return menu_items;
	}
		
	@RequestMapping("/mpanel_addn")
	public ModelAndView mpannel_add() {
		return new ModelAndView("/pages/mpanel/news_pref/add_news.jsp");
	}
	
	//map to page to update articles
	@RequestMapping("/mpanel_updn")
	public ModelAndView mpannel_upd() {
		return new ModelAndView("/pages/mpanel/news_pref/update_news.jsp");
	}
	
	//map to page to remove articles
	@RequestMapping("/mpanel_rmn")
	public ModelAndView mpanel_rm() {
		return new ModelAndView("/pages/mpanel/news_pref/remove_news.jsp");
	}
	
	//a = add - u = update - r = remove
	@RequestMapping(value = "/mpanel_aur_news", method = RequestMethod.POST)
	public @ResponseBody String mpannel_addn(@ModelAttribute("user") Users user, @RequestBody NewsRMs news_fromserver) {
		boolean isCorrectlDetails = isCorrectUser(user.getName(), user.getPassword());
		if (isCorrectlDetails) {
			ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(forworkspace_conf(News.class).getProperties()).build();
			SessionFactory sf = forworkspace_conf(News.class).buildSessionFactory(reg);
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			if (news_fromserver.getIstorm().contains("1")) {
				session.delete(news_fromserver.getNews());
			} else session.saveOrUpdate(news_fromserver.getNews());
			tx.commit();
			session.close();
			sf.close();
			reg.close();
			return "successful";
		} else { return "error";}
	}
	
	//main panel get full specific article
	@RequestMapping(value = "/mpanel_getnf", method = RequestMethod.POST)
	public @ResponseBody News mpanel_getnf(@ModelAttribute("user") Users user, @RequestBody Search search) {
		if (isCorrectUser(user.getName(), user.getPassword())) {
		return getNewsItem(search.getId());
		} else {
			return null;
		}
	}
	
	//main panel get articles without content - s = short
	@RequestMapping(value = "/mpanel_getns", method = RequestMethod.POST)
	public @ResponseBody List<News> mpannel_getns(@ModelAttribute("user") Users user) {
		boolean isCorrectlDetails = isCorrectUser(user.getName(), user.getPassword());
		if (isCorrectlDetails) {
			ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(forworkspace_conf(News.class).getProperties()).build();
			SessionFactory sf = forworkspace_conf(News.class).buildSessionFactory(reg);
			Session session = sf.openSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();

			CriteriaQuery<News> criteria = cb.createQuery(News.class);
			Root<News> contactRoot = criteria.from(News.class);
			criteria.orderBy(cb.desc(contactRoot.get(News_.date)));
			criteria.multiselect(
					contactRoot.get(News_.nid),
					contactRoot.get(News_.header),
					contactRoot.get(News_.date));
			
			List<News> news = session.createQuery(criteria).getResultList();
			
			session.close();
			sf.close();
			reg.close();
			return news;
		} else { return null; }
	}
	
	//map to main panel
	@RequestMapping(value = "/mpanel")
    public ModelAndView checkUser(@ModelAttribute("user") Users user, @RequestParam(value="logout", required=false) String lo, SessionStatus sessionStatus) {
        ModelAndView modelAndView = new ModelAndView();
        boolean isCorrectlDetails = isCorrectUser(user.getName(), user.getPassword());
        System.out.println(lo);
        if (isCorrectlDetails) {
        	modelAndView.setViewName("/pages/mpanel/mpanel.jsp");
        	modelAndView.addObject("user", user);
        } else {
        	modelAndView.setViewName("/pages/mpanel/loginmpanel.jsp");
        }
        if (lo != null) {
        	if (lo.contains("1")) {
        	System.out.println("hello");
        	sessionStatus.setComplete(); 
        	ModelAndView mav = new ModelAndView("mpanel", "user", new Users());
        	mav.setViewName("/pages/mpanel/loginmpanel.jsp");
    		return mav;
    		}
        }
        return modelAndView;
    }

	@ModelAttribute("user")
	public Users createUser(){
		return new Users("","");
	}
	
	//configuration for workspace to connect
	public Configuration forworkspace_conf(Class<?> c) {
		Properties prop = new Properties();
		prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		prop.setProperty("hibernate.connection.url", "jdbc:mysql://172.31.18.11:3306/workspace");
		prop.setProperty("hibernate.connection.username", "commonuser");
		prop.setProperty("hibernate.connection.password", "faa252004");
		prop.setProperty("hibernate.connection.characterEncoding", "utf8");
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		prop.setProperty("hbm2ddl.auto", "update");
		Configuration conf = new Configuration().addProperties(prop).addAnnotatedClass(c);
		return conf;
	}
	
	public boolean isCorrectUser(String name, String pass) {
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(forworkspace_conf(Users.class).getProperties()).build();
		SessionFactory sf = forworkspace_conf(Users.class).buildSessionFactory(reg);
		Session session = sf.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();

		CriteriaQuery<Users> criteria = cb.createQuery(Users.class);
		Root<Users> contactRoot = criteria.from(Users.class);
		
		Predicate p1 = cb.equal(contactRoot.get(Users_.name), name);
		Predicate p2 = cb.equal(contactRoot.get(Users_.password), tomd5(tosha256(tosha256(tomd5(pass)))));
		criteria.where(p1,p2);
		criteria.select(contactRoot);
		List<Users> users = session.createQuery(criteria).getResultList();
		session.close();
		sf.close();
		reg.close();
		if (users.size() == 1) {
			return true;
		}
		return false;
	}
	
	public String tomd5(String s) {
		try {
	        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
	        byte[] array = md.digest(s.getBytes());
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < array.length; ++i) {
	          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
	       }
	        return sb.toString();
	    } catch (java.security.NoSuchAlgorithmException e) {
	    }
	    return null;
	}
	
	public String tosha256(String s) {
		try {
	        java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
	        byte[] array = md.digest(s.getBytes());
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < array.length; ++i) {
	          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
	       }
	        return sb.toString();
	       } catch (java.security.NoSuchAlgorithmException e) {
	    }
	    return null;
	}
}
