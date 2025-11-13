package com.tca.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Course")
public class Course 
{
	@Id
	private Integer cid;
	private String cname;
	
	@OneToMany(mappedBy = "course", cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	List<StudentCourse> regs;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<StudentCourse> getRegs() {
		return regs;
	}

	public void setRegs(List<StudentCourse> regs) {
		this.regs = regs;
	}
	
	
	
}





