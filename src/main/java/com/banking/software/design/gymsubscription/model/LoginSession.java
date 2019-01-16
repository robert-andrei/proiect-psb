package com.banking.software.design.gymsubscription.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "login_session")
public class LoginSession {

    @Id
    @Column(name = "username", nullable = false, length = 30)
    @Length(min = 5, max = 30)
    private String username;

    @Column(name = "token")
    private String token;

    @OneToOne
    @JoinColumn(name = "username", nullable = false)
    private Customer customer;

    public LoginSession() {
    }

    public LoginSession(String username, String token) {
        this.username = username;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LoginSession that = (LoginSession) o;
        return Objects.equals(username, that.username) && Objects.equals(token, that.token);
    }

    @Override public int hashCode() {
        return Objects.hash(username, token);
    }

    @Override public String toString() {
        return "LoginSession{" + "username='" + username + '\'' + ", token='" + token + '\'' + '}';
    }
}
