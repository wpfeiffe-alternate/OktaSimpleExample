package org.arbfile.oidc.example.configuration;

import org.arbfile.oidc.example.oauth.CustomOauthLoginFailureHandler;
import org.arbfile.oidc.example.oauth.CustomOauthLoginSuccessHandler;
import org.arbfile.oidc.example.oauth.CustomOidcUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

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
            .userInfoEndpoint()
            .oidcUserService(this.oidcUserService())
            .and()
            .successHandler(customOauthLoginSuccessHandler())
            .failureHandler(customOauthLoginFailureHandler())
            .and()
            .oauth2Client();
        http.csrf().disable();

        /*
        default auto-config from Spring
    		http
			.authorizeRequests()
				.anyRequest().authenticated()
				.and()
			.formLogin().and()
			.httpBasic();
     */

    }

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

    @Bean
    public CustomOauthLoginFailureHandler customOauthLoginFailureHandler()
    {
        CustomOauthLoginFailureHandler handler = new CustomOauthLoginFailureHandler();
        handler.setUseForward(true);
        handler.setDefaultFailureUrl("/oautherror");// default if not handled by CustomOauthLoginFailureHandler
        return handler;
    }

    @Bean
    public OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService() {
        return new CustomOidcUserService();
    }

}
