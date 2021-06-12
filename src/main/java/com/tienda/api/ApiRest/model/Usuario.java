package com.tienda.api.ApiRest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String id;
	String mail;
	String password;
	boolean admin;
	
	public Usuario() {}
	
	public String toString() {
		String adm = "no";
		if(admin) adm = "yes";
		return "[Id: " + id + ", Mail: " + mail + ", Admin: " + adm + "]"; 
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getMail() {
		return this.mail;
	}
	
	public void setMail(String mail){
		this.mail = mail;
	}
	
	public boolean isAdmin() {
		return this.admin;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
