package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 基于注解方式访问
 * @author 30038737
 *
 */
@Controller
public class HelloAnnotationController {
	@RequestMapping("/hello2")
	public ModelAndView sayHello(String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "hello2 " + name);
		mav.setViewName("hello");
		System.out.println("hello2 " + name);
		return mav;
	}
}
