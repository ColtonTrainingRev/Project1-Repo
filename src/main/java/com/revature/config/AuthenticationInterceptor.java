package com.revature.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

//import com.revature.exceptions.AuthenticationFailed;
import com.revature.exceptions.NotLoggedInException;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("user") != null){
            return true;
        } else {
            throw new NotLoggedInException("Please login before interacting with application");
        }
    }
    
}
