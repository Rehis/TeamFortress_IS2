package com.tienda.api.ApiRest.model;

public class Usuario {
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
	
	String getId() {
		return this.id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	String getMail() {
		return this.mail;
	}
	
	public void setMail(String mail){
		this.mail = mail;
	}
	
	public boolean getAdmin() {
		return this.admin;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
