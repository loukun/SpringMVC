package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 第三节：方法返回值
 * @author 30038737
 *
 */
@Controller
public class ReturnController {

	@RequestMapping("/showLogin2")
	public String showLogin() {
		return "login";
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @param model 将数据存到Model对象中
	 * @return
	 */
	@RequestMapping("/login2")
	public String login(String username, String password, Model model) {
		if ("admin".equals(username) && "123".equals(password)) {
			model.addAttribute("username", username);
			return "success";
		} else {
			model.addAttribute("loginError", "username or passowrd error");
			return "login";
		}
	}
	
	@RequestMapping("/test1")
	public void test1() {
		// 将url（test1）作为视图名称
	}
}
