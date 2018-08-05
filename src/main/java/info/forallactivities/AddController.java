package info.forallactivities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("f1") String s) {
		System.out.println("Hello from servlet!!!");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://mainapp-mysql:3306/", "userhKP", "ILweMo3x");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("use workspace; select * from people;");
			while (rs.next()) {for (int i = 1; i <= 2; i++) System.out.print(rs.getString(i) + " "); System.out.println();}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success.jsp");
		mav.addObject("f1", s);
		return mav;
	}
}
