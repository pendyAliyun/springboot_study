package com.pendyliu.lesson18;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ========================
 *
 * @CLASSNAME:CustomAuthenticationEntryPoint
 * @Description:
 * @Author DELL
 * @Date 2018/11/25 22:58
 * ========================
 */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final Logger log = LoggerFactory.getLogger(CustomAutowireConfigurer.class);

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException, ServletException {
        log.info("Pri-authenticaticated endty point .Rejecting access");
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Acces is denied");
    }
}
