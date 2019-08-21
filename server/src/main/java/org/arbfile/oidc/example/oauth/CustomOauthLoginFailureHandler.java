package org.arbfile.oidc.example.oauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomOauthLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler
{
    private Logger logger = LoggerFactory.getLogger(CustomOauthLoginFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
        throws IOException, ServletException
    {
        logger.info("OAUTH custom failure handler");
        String exceptionType = exception.getClass().getCanonicalName();
        logger.info("exception type = {}", exceptionType);

        super.onAuthenticationFailure(request, response, exception);
    }
}
