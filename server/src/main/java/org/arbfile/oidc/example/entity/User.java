package org.arbfile.oidc.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User
{
    @Id
    private Long id;

    private String loginId;

    private String cocode;

    private String firstName;

    private String lastName;

    public User(){}

    public User(Long id, String loginId, String cocode, String firstName, String lastName)
    {
        this.id = id;
        this.loginId = loginId;
        this.cocode = cocode;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getLoginId()
    {
        return loginId;
    }

    public void setLoginId(String loginId)
    {
        this.loginId = loginId;
    }

    public String getCocode()
    {
        return cocode;
    }

    public void setCocode(String cocode)
    {
        this.cocode = cocode;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
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
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }

    @Override
    public String toString()
    {
        return "User{" +
            "id='" + id + '\'' +
            ", loginId='" + loginId + '\'' +
            ", cocode='" + cocode + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
    }
}
