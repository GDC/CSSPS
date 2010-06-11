package com.github.gdc.cssps.model.school;

import com.github.gdc.cssps.model.AuditedModel;
import com.github.gdc.cssps.model.exam.ExamSession;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Encapsulates the choice of school and programme selected by a student per ExamSession.
 * @author Edem Morny
 */
@Entity
public class Choice extends AuditedModel<Choice> {
    @ManyToOne
    private ExamSession session;
    @ManyToOne
    private AdmittingSchool admittingSchool;
    @ManyToOne
    private Programme programme;
    private Integer priority;
    private static final long serialVersionUID = -1724585474864163339L;

    @Override
    public String toString() {
        return "com.github.gdc.cssps.model.Choice[id=" + getId() + "]";
    }

    @Override
    public int compareTo(Choice o) {
        int result = 0;
        this.getAdmittingSchool().compareTo(o.getAdmittingSchool());
        if (result == 0) {
            return this.programme.compareTo(o.getProgramme());
        }
        return result;


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

    public ExamSession getSession() {
        return session;
    }

    public void setSession(ExamSession session) {
        this.session = session;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getPriority() {
        return priority;
    }

}
