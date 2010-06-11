/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.gdc.cssps.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *This represents information for tracking login of Users in the system. Separated from biographic data
 * about system users, which is encapsulated in <code>User</code>. There's a one to one relationship between
 * an Account and a User
 * @author edem
 */
@Entity
@Table(name="account")
public class Account extends AuditedModel<Account> {
    
    private static final long serialVersionUID = 8769830819899511172L;
    @OneToOne
    private User user;
    private String username;
    private String password;
    private boolean enabled;
    private String email;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastLogin;
    @Override
    public String toString() {
        return "com.github.gdc.cssps.model.Account[id=" + getId() + "]";
    }

    @Override
    public int compareTo(Account o) {
     if(this.username !=null){
            return this.username.compareTo(o.getUsername());
        }
        return -1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    

   
}
