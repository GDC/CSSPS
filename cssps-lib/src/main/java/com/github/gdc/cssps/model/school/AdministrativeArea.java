/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.gdc.cssps.model.school;

import com.github.gdc.cssps.model.AuditedModel;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *Defines a recursively mapped object which allow us to capture the concepts of State/Region, District etc
 * as applied to determining eligibility to be accepted into an institution.
 * @author Edem Morny
 */
@Entity
public class AdministrativeArea extends AuditedModel<AdministrativeArea>  {
    @ManyToOne
    private AdministrativeArea parent;
    private static final long serialVersionUID = 3621060371903859278L;
    private String name;    
    @OneToMany(mappedBy = "parent")
    private List<AdministrativeArea> administrativeAreas = new ArrayList<AdministrativeArea>();

    @Override
    public String toString() {
        return "com.github.gdc.cssps.model.AdministrativeArea[id=" + getId() + "]";
    }

    @Override
    public int compareTo(AdministrativeArea o) {
        if(this.parent !=null && this.getParent().equals(o.getParent())){
            if(this.getName() !=null)return this.getName().compareTo(o.getName());
        }
        return -1;
    }

    public List<AdministrativeArea> getAdministrativeAreas() {
        return administrativeAreas;
    }

    public void setAdministrativeAreas(List<AdministrativeArea> administrativeAreas) {
        this.administrativeAreas = administrativeAreas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AdministrativeArea getParent() {
        return parent;
    }

    


}
