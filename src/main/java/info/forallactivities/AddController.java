package info.forallactivities;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("f1") String s) {
		System.out.println("Hello from servlet");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success.jsp");
		mav.addObject("f1", s);
		return mav;
	}
}
