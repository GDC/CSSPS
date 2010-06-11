/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.gdc.cssps.model.exam;

import com.github.gdc.cssps.model.AuditedModel;
import com.github.gdc.cssps.model.school.Subject;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *Represents results obtained per subject for an ExamSession.
 * 
 * @author edem
 */
@Entity
@Table(name="subject_result")
public class SubjectResult extends AuditedModel<SubjectResult> {
    private static final long serialVersionUID = -4813049667075860254L;
    @ManyToOne
    private Subject subject;
    private double score;
    @ManyToOne
    private ExamSession examSession;


    @Override
    public String toString() {
        return "com.github.gdc.cssps.model.SubjectResult[id=" + getId() + "]";
    }

    @Override
    public int compareTo(SubjectResult o) {
        if(this.examSession !=null && this.examSession.equals(o.getExamSession())){
            if(this.getSubject() !=null)return this.getSubject().compareTo(o.getSubject());
        }
        return this.getExamSession().compareTo(o.getExamSession());
    }

    public ExamSession getExamSession() {
        return examSession;
    }

    public void setExamSession(ExamSession examSession) {
        this.examSession = examSession;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }


}
