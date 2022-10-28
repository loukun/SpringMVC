package controller;

import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
