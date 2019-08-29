package org.arbfile.oidc.example.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SecurityUser
{
    private List<String> privileges;
    private boolean loggedIn;
    private Date loginTime;

    private boolean autoLogin;
    private boolean internalIdpUser;
    private boolean samlUser;
    private boolean needsTermsAgreement;

    public SecurityUser()
    {
        this.privileges = new ArrayList<>();
    }

    public List<String> getPrivileges()
    {
        return privileges;
    }

    public void setPrivileges(List<String> privileges)
    {
        this.privileges = privileges;
    }

    public boolean isLoggedIn()
    {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn)
    {
        this.loggedIn = loggedIn;
    }

    public Date getLoginTime()
    {
        return loginTime;
    }

    public void setLoginTime(Date loginTime)
    {
        this.loginTime = loginTime;
    }

    public boolean isAutoLogin()
    {
        return autoLogin;
    }

    public void setAutoLogin(boolean autoLogin)
    {
        this.autoLogin = autoLogin;
    }

    public boolean isInternalIdpUser()
    {
        return internalIdpUser;
    }

    public void setInternalIdpUser(boolean internalIdpUser)
    {
        this.internalIdpUser = internalIdpUser;
    }

    public boolean isSamlUser()
    {
        return samlUser;
    }

    public void setSamlUser(boolean samlUser)
    {
        this.samlUser = samlUser;
    }

    public boolean isNeedsTermsAgreement()
    {
        return needsTermsAgreement;
    }

    public void setNeedsTermsAgreement(boolean needsTermsAgreement)
    {
        this.needsTermsAgreement = needsTermsAgreement;
    }

    @Override
    public String toString()
    {
        return "SecurityUser{" +
            "privileges=" + privileges +
            ", loggedIn=" + loggedIn +
            ", loginTime=" + loginTime +
            ", autoLogin=" + autoLogin +
            ", internalIdpUser=" + internalIdpUser +
            ", samlUser=" + samlUser +
            ", needsTermsAgreement=" + needsTermsAgreement +
            '}';
    }
}
