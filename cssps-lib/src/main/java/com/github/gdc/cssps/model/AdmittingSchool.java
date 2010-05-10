package com.github.gdc.cssps.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 * This represents a school that students may be placed in.
 * 
 * @author Edem Morny
 */
@Entity
public class AdmittingSchool extends OriginSchool {
    private static final long serialVersionUID = 8284317557860440242L;
    
    @OneToMany
    @JoinTable(
        name = "school_programmes",
        joinColumns = {@JoinColumn(name = "school_id")},
        inverseJoinColumns = {@JoinColumn(name = "programme_id")}
    )
    private Set<Programme> programmes = new HashSet<Programme>();

    @Enumerated(EnumType.STRING)
    private AcceptedGender acceptedGender;

    public AcceptedGender getAcceptedGender() {
        return acceptedGender;
    }

    public void setAcceptedGender(AcceptedGender acceptedGender) {
        this.acceptedGender = acceptedGender;
    }

    

    public void setProgrammes(Set<Programme> programmes) {
        this.programmes = programmes;
    }

    public Set<Programme> getProgrammes() {
        return programmes;
    }

    
    @Override
    public String toString() {
        return "com.github.gdc.csps.model.AdmittingSchool[id=" + getId()+ "]";
    }

}
