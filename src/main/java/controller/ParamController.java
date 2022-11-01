package controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entity.UserVo;

@Controller
@RequestMapping("/param")
public class ParamController {

	/**
	 * 方法的参数，使用JAVAEE组件
	 * @param req
	 * @param resp
	 * @param session
	 */
	@RequestMapping("/test1")
	public void test1(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		req.getParameter("username");
	}
	
	/**
	 * 获取输入流和输出流，相当于HttpServletRequest中的输入/出流
	 * @param is
	 * @param os
	 */
	@RequestMapping("/test2")
	public void test2(InputStream is, OutputStream os) {
		// 相当于如下代码
		// req.getInputStream();
		// resp.getOutputStream();
		System.out.println("ParamController.test2," +is+"," + os);
	}
	
	/**
	 * 向界面传数据
	 * @param model
	 * @return
	 */
	@RequestMapping("/test3")
	public String test3(Model model, Map<String, String> map, ModelMap modelMap) {
		model.addAttribute("model", "向页面输出Model");
		map.put("map", "向页面输出Map");
		modelMap.addAllAttributes(map);
		return "model";
	}
	/**
	 * 表示参数来源于请求参数，参数值来源于同名的请求参数
	 * @param username
	 * @return
	 */
	@RequestMapping("/test4")
	public String test4(@RequestParam String username) {
		System.out.println("username：" + username);
		return "model";
	}
	
	/**
	 * 表示参数来源于请求参数，@RequestParam配置绑定参数名，配置成URL中的参数名
	 * @param username
	 * @return
	 */
	@RequestMapping("/test5")
	public String test5(@RequestParam(name="name") String username) {
		System.out.println("username：" + username);
		return "model";
	}
	
	/**
	 * 从URL的路径中取得数据
	 * @param username
	 * @return
	 */
	@RequestMapping("/test6/{id}")
	public String test6(@PathVariable String id) {
		System.out.println("id：" + id);
		return "model";
	}
	
	/**
	 * 从请求头得到信息
	 * @param userAgent
	 * @param cookie
	 * @return
	 */
	@RequestMapping("/test7")
	public String test7(@RequestHeader("User-Agent") String userAgent, @RequestHeader("Cookie") String cookie) {
		System.out.println("User-Agent " + userAgent + ",Cookie " + cookie);
		return "success";
	}
	
	/**
	 * 添加Cookie
	 * @return
	 */
	@RequestMapping("/setCookie")
	public String setCookie(HttpServletResponse resp) {
		Cookie cookie = new Cookie("username","admin");
		cookie.setMaxAge(7*24*60*60);
		resp.addCookie(cookie);
		return "success";
	}
	
	/**
	 * 直接取得Cookie
	 * @param username
	 * @param sessionId
	 * @return
	 */
	@RequestMapping("/test8")
	public String test8(@CookieValue String username, @CookieValue("JSESSIONID") String sessionId) {
		System.out.println("username " + username + ",sessionId " + sessionId);
		return "success";
	}
	
	/**
	 * 从请求体拿数据
	 * @param requestBody
	 * @return
	 */
	@RequestMapping("/test9")
	public String test9(@RequestBody String requestBody) {
		System.out.println("requestBody " + requestBody);
		return "success";
	}
	
	/**
	 * 自定义类型，参数前添加注释@ModelAttribute，可将表单中同名的数据自动转换成自定义类型中的属性值。
	 * @param userVo
	 * @return
	 */
	@RequestMapping("/test10")
	public String regist(@ModelAttribute UserVo userVo) {
		System.out.println("UserVo： " + userVo.toString());
		return "success";
	}
	
	/**
	 * 显示注册页面
	 * @return
	 */
	@RequestMapping("showRegiest")
	public String showRegiest() {
		return "regiest";
	}
	
	
	/**
	 * 在方法的上面添加该注释
	 * 作用：在调用所有目标方法前都会调用添加了@ModelAttribute注释的方法，并向模型中添加数据（一般用于向画面预先加载数据，例如下拉列表中的数据等）
	 * @return
	 */
	@ModelAttribute("sex")
	public List<String> getSex() {
		List<String> list = Arrays.asList("男", "女");
		return list;
	}
}
