package com.tca.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="student_course")
public class StudentCourse 
{
	@Id
	private Integer id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_RNO")
	private Student student;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_CID")
	private Course course;
	
	@Column(name="REG_DATE")
	private LocalDate regdate;   // Discriptive Attribute
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public LocalDate getRegdate() {
		return regdate;
	}

	public void setRegdate(LocalDate regdate) {
		this.regdate = regdate;
	}
	

	
	
	
}
