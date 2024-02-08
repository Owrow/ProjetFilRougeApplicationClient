package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FiltreConnexion extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String path = httpRequest.getServletPath();
		System.out.println(path);
		if ("/ServletConnection".equals(path)) {
			chain.doFilter(httpRequest, httpResponse);
		} else if (path.endsWith(".css")) {
			chain.doFilter(httpRequest, httpResponse);
		} else if (httpRequest.getSession().getAttribute("client") != null) {
			chain.doFilter(httpRequest, httpResponse);
		} else {
			httpResponse.sendRedirect("ServletConnection");
		}
	}
}
