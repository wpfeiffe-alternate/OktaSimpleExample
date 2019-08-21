package org.arbfile.oidc.example.configuration;

import org.arbfile.oidc.example.oauth.CustomOauthLoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
//        http.authorizeRequests()
//            .antMatchers("/**").permitAll();
        http.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .oauth2Login()
            .successHandler(customOauthLoginSuccessHandler())
            .and()
            .oauth2Client();
        http.csrf().disable();
    }

    /*
    default from Spring
    		http
			.authorizeRequests()
				.anyRequest().authenticated()
				.and()
			.formLogin().and()
			.httpBasic();
     */
    @Bean
    AllowAllCorsFilter corsFilter()
    {
        AllowAllCorsFilter filter = new AllowAllCorsFilter();
        return filter;
    }

    @Bean
    public CustomOauthLoginSuccessHandler customOauthLoginSuccessHandler()
    {
        CustomOauthLoginSuccessHandler handler = new CustomOauthLoginSuccessHandler();
        // handler.setDefaultTargetUrl("/"); TODO: may need to do this like SAML
        return handler;
    }
}
