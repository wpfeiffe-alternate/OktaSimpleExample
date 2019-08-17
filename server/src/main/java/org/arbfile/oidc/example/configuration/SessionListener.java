package org.arbfile.oidc.example.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Component
public class SessionListener implements HttpSessionListener
{
    private Logger logger = LoggerFactory.getLogger(SessionListener.class);

    @Override
    public void sessionDestroyed(HttpSessionEvent se)
    {
        String sessionId = se.getSession().getId();
        logger.info("HTTP session {} destroyed", sessionId);
    }
}
