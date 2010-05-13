
package com.github.gdc.cssps.model;

import javax.persistence.Entity;

/**
 *Represent the school that the student was in at the time of sitting the exam.
 * @author Edem Morny
 */
@Entity
public class OriginSchool extends AuditedModel<OriginSchool>{
    private static final long serialVersionUID = 428827157239831829L;
    private String name;
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public int compareTo(OriginSchool o) {
        if(this.getName() == null)return -1;
        return this.getName().compareTo(o.getName());
    }
    
    @Override
    public String toString() {
        return "com.github.gdc.csps.model.OriginSchool[id=" + getId() + "]";
    }

}
