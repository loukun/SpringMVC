package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
/**
 * 基于实现接口方式访问
 * @author 30038737
 *
 */
public class HelloController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 初次搭建SpringMVC框架的测试用例
		String name = request.getParameter("name");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "hello " + name);
		mav.setViewName("hello");
		System.out.println(name);
		return mav;
	}
}
