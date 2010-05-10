package com.github.gdc.cssps.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 * Stores data about a student
 * @author Edem Morny
 */
@Entity
public class Student extends Model<Student> {
    @OneToMany(mappedBy = "student")
    private List<ExamSession> examSessions;
    private static final long serialVersionUID = 8033084129011434043L;
    private String firstName;
    private String lastName;
    private String otherNames;
    private String email;
    private String phone;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthDate;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<ExamSession> getExamSessions() {
        return examSessions;
    }

    public void setExamSessions(List<ExamSession> examSessions) {
        this.examSessions = examSessions;
    }

    

    @Override
    public int compareTo(Student o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public String toString() {
        return "com.github.gdc.csps.model.Student[id=" + getId()+ "]";
    }

}
