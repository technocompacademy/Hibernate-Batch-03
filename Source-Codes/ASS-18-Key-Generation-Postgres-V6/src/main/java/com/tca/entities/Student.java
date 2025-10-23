package com.tca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table(name="student")
public class Student 
{
	
/*	
	@Id                 								// Use 'rno' as primary key column
	@GeneratedValue(strategy = GenerationType.AUTO)  // Based dialect class you decide way to create Autoincrement 
	@Column(name="RNO")         						// Use 'RNO' as Column name
	private Integer rno;
*/	

/*	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RNO")
	private Integer rno;
*/	

/*
	@Id
	@SequenceGenerator(name="sg", sequenceName="sacseq",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sg")
	@Column(name="RNO")
	private Integer rno;
*/
	
	@Id
	@TableGenerator(name="tg", table="mytab", pkColumnName = "myid", pkColumnValue = "100", valueColumnName = "next_hi", initialValue=700,  allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tg")
	@Column(name="RNO")
	private Integer rno;
	
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PER")
	private Double per;
	
	
		
	
	public Integer getRno() {
		return rno;
	}

	public void setRno(Integer rno) {
		this.rno = rno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPer() {
		return per;
	}

	public void setPer(Double per) {
		this.per = per;
	}

	@Override
	public String toString() {
		return "Student [rno=" + rno + ", name=" + name + ", per=" + per +  "]";
	}

	

	
	
	
	
	
}
