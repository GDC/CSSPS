package com.github.gdc.cssps.model.exam;

import com.github.gdc.cssps.model.AuditedModel;
import com.github.gdc.cssps.model.school.Subject;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 * An Exam models one that is taken periodically, be it yearly , monthly etc. As of this implementation,
 * the subjects taken per exam are directly defined here, however this should be in the future removed to ExamSession,
 * as already defined in ExamSession implementation.
 * 
 * @author Edem Morny
 */
@Entity
public class Exam extends AuditedModel<Exam> {
    private static final long serialVersionUID = -6380239434086393159L;

    private String name;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date examYear;

    @OneToMany
    @JoinTable(
        name = "exam_subjects",
        joinColumns = {@JoinColumn(name = "exam_id")},
        inverseJoinColumns = {@JoinColumn(name = "subject_id")}
    )
    private Set<Subject> subjects = new HashSet<Subject>();

    public Date getExamYear() {
        return examYear;
    }

    public void setExamYear(Date examYear) {
        this.examYear = examYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    
    @Override
    public int compareTo(Exam o) {
        if (this.getName() == null) {
            return -1;
        }
        if (this.getName().equalsIgnoreCase(o.getName())) {
            if (this.getExamYear() == null) {
                return -1;
            }
            return (this.getExamYear().compareTo(o.getExamYear()));
        }else{
            return this.getName().compareTo(o.getName());
        }
    }

    @Override
    public String toString() {
        return "com.github.gdc.csps.model.Exam[id=" + getId() + "]";
    }
}
