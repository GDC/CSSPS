/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.gdc.cssps.model.school;

import com.github.gdc.cssps.model.AuditedModel;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *Represents results obtained per subject for an ExamSession.
 * 
 * @author edem
 */
@Entity
@Table(name="admission_limits")
public class AdmissionLimit extends AuditedModel<AdmissionLimit> {
    private static final long serialVersionUID = -4813049667075860254L;
    @ManyToOne
    private Programme programme;
    private int ceiling;
    @ManyToOne
    private AdmittingSchool admittingSchool;

    @Override
    public String toString() {
        return "com.github.gdc.cssps.model.SubjectResult[id=" + getId() + "]";
    }

    @Override
    public int compareTo(AdmissionLimit o) {
        if(this.getAdmittingSchool() !=null && this.getAdmittingSchool().equals(o.getAdmittingSchool())){
            if(this.getProgramme() !=null)return this.getProgramme().compareTo(o.getProgramme());
        }
        return this.getAdmittingSchool().compareTo(o.getAdmittingSchool());
    }

    public AdmittingSchool getAdmittingSchool() {
        return admittingSchool;
    }

    public void setAdmittingSchool(AdmittingSchool admittingSchool) {
        this.admittingSchool = admittingSchool;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public void setCeiling(int ceiling) {
        this.ceiling = ceiling;
    }

    public int getCeiling() {
        return ceiling;
    }

}
