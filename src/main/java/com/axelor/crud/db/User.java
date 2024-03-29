package com.axelor.crud.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.axelor.crud.utils.ServerVariables;

@Entity
@Table(name=ServerVariables.TABLE_NAME_FOR_USER)
public class User {
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO) 
	   private int id;
	   
	   @Column(name="name", columnDefinition = "varchar(50)")
	   private String name;
	   
	   @Column(name="email", columnDefinition = "varchar(50)")
	   private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	   
	   
	   
	   
	   
}
