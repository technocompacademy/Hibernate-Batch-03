package com.tca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="EXE3")
@PrimaryKeyJoinColumn(name="eid")
public class Executive extends Employee 
{
	@Column(name="erole")
	private String erole;

	public String getErole() {
		return erole;
	}

	public void setErole(String erole) {
		this.erole = erole;
	}
	
	
	
}
