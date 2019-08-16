package org.arbfile.oidc.example.dto;

import java.util.Objects;

public class AuthUser
{
    private String loginId;
    private String[] authorities;

    public AuthUser(String loginId)
    {
        this.loginId = loginId;
        this.authorities = new String[0];
    }

    public String getLoginId()
    {
        return loginId;
    }

    public void setLoginId(String loginId)
    {
        this.loginId = loginId;
    }

    public String[] getAuthorities()
    {
        return authorities;
    }

    public void setAuthorities(String[] authorities)
    {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        AuthUser authUser = (AuthUser) o;
        return loginId.equals(authUser.loginId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(loginId);
    }
}
