

package com.github.gdc.cssps.model;

import javax.persistence.Entity;

/**
 * Captures data about programmes that are offered by school, which determine the
 * eligibility of students for that school
 * @author Edem Morny
 */
@Entity
public class Programme extends Model<Programme> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Programme o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    

    @Override
    public String toString() {
        return "com.github.gdc.csps.model.Programme[id=" + getId() + "]";
    }

}
