
package com.github.gdc.cssps.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * An ExamSession encapsulated data about when a student sat an exam, and at what school the student sat
 * the exam. This is to handle the case of a student sitting the same exam more than once.
 * @author Edem Morny
 */
@Entity
public class ExamSession extends Model<ExamSession>{
    private static final long serialVersionUID = 4450998950834796171L;
    @ManyToOne
    private Exam exam;
    @ManyToOne
    private Student student;
    @OneToOne
    private OriginSchool originSchool;

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public OriginSchool getOriginSchool() {
        return originSchool;
    }

    public void setOriginSchool(OriginSchool originSchool) {
        this.originSchool = originSchool;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int compareTo(ExamSession o) {
        if(this.getExam()==null )return -1;
        if(this.getStudent()==null)return -1;
        if(this.getOriginSchool() ==null)return -1;
        if(this.getExam().equals(o.getExam())){
            if(this.getStudent().equals(o.getStudent())){
                return this.getOriginSchool().compareTo(o.getOriginSchool());
            }
            return this.getStudent().compareTo(o.getStudent());
        }
        return this.getExam().compareTo(o.getExam());
    }
    

    @Override
    public String toString() {
        return "com.github.gdc.csps.model.ExamSession[id=" + getId() + "]";
    }

}
