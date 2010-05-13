

package com.github.gdc.cssps.model;

import java.util.Date;
import javax.persistence.MappedSuperclass;

/**
 *Abstract class extending Model with additional data such as date created, user who created it etc.
 *
 * @author Edem Morny
 */
@MappedSuperclass
public abstract class AuditedModel<E extends Model> extends Model<E>{
    private Date createdOn;
    private Date lastModifiedDate;
    private User createdBy;

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    

}
