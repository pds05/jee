package ru.flamexander.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(servletNames = {
        "AddCalcServlet",
        "SubtractCalcServlet",
        "MultiplyCalcServlet",
        "DivCalcServlet"},
        urlPatterns = {"/add", "/subtract", "/multiply", "/div"}
)
public class CalcFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(CalcFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        logger.info("New request " + request.getRequestURI() + "?" + request.getQueryString());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
