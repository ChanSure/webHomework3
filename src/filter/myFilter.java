package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "myFilter", urlPatterns = {"/addServlet/*","/logoutServlet/*","/doneServlet/*"})
public class myFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        Object isLogin = request.getSession().getAttribute("login");
        if (null != isLogin){
            chain.doFilter(req, resp);
        } else {
            //重定向
            response.sendRedirect(request.getContextPath()+"/login.html");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}