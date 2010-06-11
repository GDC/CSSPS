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
 *
 * @author edem
 */
@Entity
@Table(name = "users")
public class User extends AuditedModel<User> {

    private static final long serialVersionUID = 8769830819899511172L;
    private String firstName;
    private String lastName;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthDate;
    private Character gender;
    @OneToOne(mappedBy = "user")
    private Account account;

    @Override
    public String toString() {
        return "com.github.gdc.cssps.model.User[id=" + getId() + "]";
    }

    @Override
    public int compareTo(User o) {
        if (this.getBirthDate() != null && this.getBirthDate().equals(o.getBirthDate())) {
            if (this.getFirstName() != null && this.getFirstName().equals(o.getFirstName())) {
                if (this.getLastName() != null) {
                    return this.getLastName().compareTo(o.getLastName());
                }
                return this.getFirstName().compareTo(o.getFirstName());
            }
            return this.getBirthDate().compareTo(o.getBirthDate());
        }
        return -1;

    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
