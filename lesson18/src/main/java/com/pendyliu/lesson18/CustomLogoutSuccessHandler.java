package com.pendyliu.lesson18;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ========================
 *
 * @CLASSNAME:CustomLogoutSuccessHandler
 * @Description:
 * @Author DELL
 * @Date 2018/11/25 23:07
 * ========================
 */
@Component
public class CustomLogoutSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler
        implements LogoutSuccessHandler {
    private static final String BEARER_AUTHENTICATION = "Bearer ";
    private static final String HEADER_AUTHORIZATION = "authorization";

    private TokenStore tokenStore;
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Authentication authentication) throws IOException, ServletException {
        String token=httpServletRequest.getHeader(HEADER_AUTHORIZATION);
        if(token!=null&&token.startsWith(BEARER_AUTHENTICATION)){
            OAuth2AccessToken oAuth2AccessToken=tokenStore.readAccessToken(token.split("")[0]);
            if(oAuth2AccessToken!=null){
                tokenStore.removeAccessToken(oAuth2AccessToken);
            }
        }
    }
}
