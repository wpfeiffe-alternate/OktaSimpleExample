package org.arbfile.oidc.example.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("application")
public class ApplicationProperties
{
    private String postauthredirect;

    public String getPostauthredirect()
    {
        return postauthredirect;
    }

    public void setPostauthredirect(String postauthredirect)
    {
        this.postauthredirect = postauthredirect;
    }
}

// NOTES
// Read properties from a yml file
//https://www.techiedelight.com/read-values-from-yaml-file-spring-boot/
