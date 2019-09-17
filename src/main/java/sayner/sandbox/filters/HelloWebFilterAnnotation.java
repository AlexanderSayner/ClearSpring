package sayner.sandbox.filters;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class HelloWebFilterAnnotation implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req=(HttpServletRequest)request;
		
		String ipAddress=req.getRemoteAddr();
		
		String format="IP %s, Time %s";
		System.out.println(String.format(format, ipAddress, new Date()));
		
		chain.doFilter(request, response);

	}
	
	@Override
	public void init(FilterConfig config) {
		
		// Get initialization parameter 
		String testParam = config.getInitParameter("test-param");
		System.out.println(String.format("Test parameter: %s", testParam));
	}

}
