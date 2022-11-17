package interceptor;

import java.lang.reflect.Method;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HelloInterceptor implements HandlerInterceptor {

	/**
	 * 调用目标方法之前执行，可以做权限等
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {
			// 参数handler本质上就是HandlerMethod实例
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Object bean = handlerMethod.getBean();
			Method method = handlerMethod.getMethod();
			System.out.println("HelloInterceptor.preHandle,bean: " + bean.getClass() + ", method: " + method.getName() + ",args: " + Arrays.toString(method.getParameterTypes()));
		}
		return true;
	}

	/**
	 * 调用目标方法之后执行，渲染视图之前，可以对数据模型或视图进行修改
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HelloInterceptor.postHandle");
	}

	/**
	 * 渲染视图之后，可以用来释放资源
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HelloInterceptor.afterCompletion");
	}

}
