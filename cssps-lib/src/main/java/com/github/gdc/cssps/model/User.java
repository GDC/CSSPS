/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.gdc.cssps.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author edem
 */
@Entity
@Table(name="users")
public class User extends AuditedModel<User> {
    private static final long serialVersionUID = 8769830819899511172L;
    
    @Override
    public String toString() {
        return "com.github.gdc.cssps.model.User[id=" + getId() + "]";
    }

    @Override
    public int compareTo(User o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    

}
