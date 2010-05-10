

package com.github.gdc.cssps.model;

import javax.persistence.Entity;

/**
 * Encapsulates knowledge about the individual courses that a student sits an exam for in an exam session.
 * 
 * @author Edem Morny
 */
@Entity
public class Subject extends Model<Subject>{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Subject o) {
        if(this.name ==null)return -1;
        return this.getName().compareTo(o.getName());
    }

    
    

    @Override
    public String toString() {
        return "com.github.gdc.csps.model.Subject[id=" + getId() + "]";
    }

}
