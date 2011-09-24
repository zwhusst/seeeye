/*
 * Created on 2011-8-17
 */

package com.ehealth.eyedpt.mvc.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.filter.GenericFilterBean;

import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.mvc.constants.SessionConstants;
import com.ehealth.eyedpt.mvc.context.BeanResolver;
import com.ehealth.eyedpt.mvc.services.UserService;

/**
 * Security filter that does it work after spring filters.
 * 
 * @author emac
 * @see UsernamePasswordAuthenticationFilter
 * @see LogoutFilter
 */
public class PostSpringSecurityFilter extends GenericFilterBean
{

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterchain)
            throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        // TODO#EMAC.P3 delegate to corresponding filter based on request URL
        setUserSessionProperty(request);

        filterchain.doFilter(request, response);
    }

    private void setUserSessionProperty(HttpServletRequest request)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if ( authentication == null )
        {
            request.getSession().setAttribute(SessionConstants.ATTR_USER, null);
        }
        else
        {
            User user = (User) request.getSession().getAttribute(SessionConstants.ATTR_USER);
            if ( user == null )
            {
                String username = authentication.getName();
                user = findUserByName(username);
                request.getSession().setAttribute(SessionConstants.ATTR_USER, user);
            }
        }
    }

    private User findUserByName(String username)
    {
        UserService userService = BeanResolver.getBean(UserService.class);

        return userService.findByName(username);
    }

}
