package com.tca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="student")

@NamedQueries(
		value = {
					@NamedQuery(name="GET_ALL_INFO", query="FROM Student"),
					@NamedQuery(name="GET_CITYWISE", query="FROM Student where city= :abc "),
					@NamedQuery(name="MODIFY_STUDENT_CITY", 
								query="UPDATE Student SET city= :ncity WHERE city= :ocity"),
					@NamedQuery(name="REMOVE_STUDENT",
								query="DELETE FROM Student where rno=:rollnumber")
				} 
		)

public class Student 
{
	@Id
	@Column(name="srno")
	private Integer rno;
	
	@Column(name="sname")
	private String name;

	@Column(name="sper")
	private Double per;
	
	@Column(name="scity")
	private String city;
	
	public Student() {}
	
	public int getRno() {
		return rno;
	}
	
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPer() {
		return per;
	}
	public void setPer(double per) {
		this.per = per;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}
