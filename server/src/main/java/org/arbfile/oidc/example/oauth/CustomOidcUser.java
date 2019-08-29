package org.arbfile.oidc.example.oauth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import java.util.Collection;

public class CustomOidcUser extends DefaultOidcUser
{
    /**
     * The AF Security User can be stored here
     */
    private Object customUserDetails;

    public CustomOidcUser(Collection<? extends GrantedAuthority> authorities, OidcIdToken idToken)
    {
        super(authorities, idToken);
    }

    public CustomOidcUser(Collection<? extends GrantedAuthority> authorities, OidcIdToken idToken, String nameAttributeKey)
    {
        super(authorities, idToken, null, nameAttributeKey);
    }

    public CustomOidcUser(Collection<? extends GrantedAuthority> authorities, OidcIdToken idToken, OidcUserInfo userInfo)
    {
        super(authorities, idToken, userInfo, IdTokenClaimNames.SUB);
    }

    public CustomOidcUser(Collection<? extends GrantedAuthority> authorities, OidcIdToken idToken,
                          OidcUserInfo userInfo, String nameAttributeKey)
    {
        super(authorities, idToken, userInfo, nameAttributeKey);
    }

    public CustomOidcUser(OidcUser defaultOidcUser)
    {
        super(defaultOidcUser.getAuthorities(), defaultOidcUser.getIdToken(), defaultOidcUser.getUserInfo(), IdTokenClaimNames.SUB );
    }

    public Object getCustomUserDetails()
    {
        return customUserDetails;
    }

    public void setCustomUserDetails(Object customUserDetails)
    {
        this.customUserDetails = customUserDetails;
    }
}
