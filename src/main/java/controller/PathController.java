package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author 30038737
 *
 */
@Controller
@RequestMapping("/path")
public class PathController {

	@RequestMapping("/showLogin")
	public String showLogin() {
		return "login";
	}
	
	/**
	 * 星号可以匹配任意字符，正斜杠必须有，只能匹配单层目录
	 * @return
	 */
	@RequestMapping("/test1/*")
	public String test1() {
		return "hello";
	}
	
	/**
	 * 星星号可以匹配任意字符，匹配多层目录
	 * @return
	 */
	@RequestMapping("/test2/**")
	public String test2() {
		return "hello";
	}
	
	/**
	 * 问号可以匹配任意字符，匹配多层目录
	 * @return
	 */
	@RequestMapping("/test3/?")
	public String test3() {
		return "hello";
	}
	
	/**
	 * Rest风格
	 * id和name必须存在于URL中，否则404
	 * @return
	 */
	@RequestMapping("/test5/{id}/{name}")
	public String test5(@PathVariable String id, @PathVariable("name") String username) {
		System.out.println("id: " + id + "username: " + username);
		return "hello";
	}
	/**
	 * 固定写法
	 * path是value的别名
	 * value是个数组，可以用多个URL访问该方法
	 * @return
	 */
	//@RequestMapping("/test6")
	//@RequestMapping(path="/test6")
	//@RequestMapping(value="/test6")
	@RequestMapping(value={"/test6", "/test7"})
	public String test6() {
		return "hello";
	}
	
	/**
	 * 根据请求方式访问
	 * @return
	 */
	
	@RequestMapping(path="/test7", method = RequestMethod.POST)
	public String test7() {
		return "hello";
	}
}
