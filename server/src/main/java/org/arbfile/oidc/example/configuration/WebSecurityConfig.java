package org.arbfile.oidc.example.configuration;

import org.arbfile.oidc.example.oauth.CustomOauthLoginFailureHandler;
import org.arbfile.oidc.example.oauth.CustomOauthLoginSuccessHandler;
import org.arbfile.oidc.example.oauth.CustomOidcUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
//    @Autowired
//    private CustomAuthenticationProvider customAuthenticationProvider;

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
            .oidcUserService(this.customOidcUserService())
            .and()
            .successHandler(customOauthLoginSuccessHandler())
            .failureHandler(customOauthLoginFailureHandler())
//            .and()
            //.authenticationDetailsSource()
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

    public CustomOidcUserService customOidcUserService()
    {
        return new CustomOidcUserService();
    }

//    @Bean
//    public CustomAuthenticationProvider customAuthenticationProvider()
//    {
//        return new CustomAuthenticationProvider();
//    }

     // this is not working, I am unable to add an AuthenticationProvider to the Auth Flow.
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService()
//        auth.authenticationProvider(customAuthenticationProvider);
//    }

    // This is an alternate method I tried but did not work either
//    @Autowired
//    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception
//    {
//        auth.authenticationProvider(customAuthenticationProvider);
//    }

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

//    public OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService() {
//        return new CustomOidcUserService();
//    }

}
