package com.github.gdc.cssps.model.school;

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
        name = "school_limits",
        joinColumns = {@JoinColumn(name = "school_id")},
        inverseJoinColumns = {@JoinColumn(name = "limit_id")}
    )
    private Set<AdmissionLimit> admissionLimits = new HashSet<AdmissionLimit>();

    @Enumerated(EnumType.STRING)
    private AcceptedGender acceptedGender;

    public AcceptedGender getAcceptedGender() {
        return acceptedGender;
    }

    public void setAcceptedGender(AcceptedGender acceptedGender) {
        this.acceptedGender = acceptedGender;
    }

    

    public void setAdmissionLimit(Set<AdmissionLimit> programmes) {
        this.admissionLimits = programmes;
    }

    public Set<AdmissionLimit> getAdmissionLimit() {
        return admissionLimits;
    }

    
    @Override
    public String toString() {
        return "com.github.gdc.csps.model.AdmittingSchool[id=" + getId()+ "]";
    }

}
