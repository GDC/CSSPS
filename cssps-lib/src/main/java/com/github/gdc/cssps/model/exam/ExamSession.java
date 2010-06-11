
package com.github.gdc.cssps.model.exam;

import com.github.gdc.cssps.model.AuditedModel;
import com.github.gdc.cssps.model.school.Choice;
import com.github.gdc.cssps.model.school.OriginSchool;
import com.github.gdc.cssps.model.Student;
import com.github.gdc.cssps.model.school.Subject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 * An ExamSession encapsulated data about when a student sat an exam, and at what school the student sat
 * the exam. This is to handle the case of a student sitting the same exam more than once.
 * @author Edem Morny
 */
@Entity
public class ExamSession extends AuditedModel<ExamSession>{
    @OneToMany(mappedBy = "examSession")
    private List<SubjectResult> subjectResults;
    @OneToMany(mappedBy = "session")
    private List<Choice> choices = new ArrayList<Choice>();
    private static final long serialVersionUID = 4450998950834796171L;
    @ManyToOne
    private Exam exam;
    @ManyToOne
    private Student student;
    @OneToOne
    private OriginSchool originSchool;
    @Transient
    private Set<Subject> subjectsTaken = new HashSet<Subject>();
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

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
    /**
     * Determines the subjects that were taken in this exam session.
     * Currently read from the Exam directly, but in future implementations
     * this should be where subjects taken should be determined
     * @return
     */
    public Set<Subject> getSubjectsTaken() {
        if(subjectsTaken.isEmpty())
        if(exam !=null)return exam.getSubjects();
        return subjectsTaken;
    }

    public void setSubjectsTaken(Set<Subject> subjectsTaken) {
        this.subjectsTaken = subjectsTaken;
    }



    
}
