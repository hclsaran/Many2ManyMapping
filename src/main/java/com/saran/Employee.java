package com.saran;

import java.util.HashSet;
import java.util.Set;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
@Entity
@Table(name="EMPLOYEEM2M")
public class Employee {
     
    @Id
    @Column(name="EMPLOYEE_ID")
    @GeneratedValue
    private Long employeeId;
     
    @Column(name="FIRSTNAME")
    private String firstname;
     
    @Column(name="LASTNAME")
    private String lastname;
     
   //ManyToMany->Many emp will have many meetings @JoinTable ->create a 3rd table  
    //called employee_meeting having employee_id and meeting id )
    @ManyToMany(cascade = {CascadeType.ALL})//create many2many relationhsip between emp and meeting entities    
    @JoinTable(name="EMPLOYEE_MEETING", 
                joinColumns={@JoinColumn(name="EMPLOYEE_ID")}, 
                inverseJoinColumns={@JoinColumn(name="MEETING_ID")})
    private Set<Meeting> meetings = new HashSet<>();//HAS A
     
    public Employee() {
    }
 
    public Employee(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Set<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(Set<Meeting> meetings) {
		this.meetings = meetings;
	}
         
   
}