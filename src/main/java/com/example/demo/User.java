package com.example.demo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
@Builder
public class User  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

   private String email;
    
    private String password;
    
	private String nom;
    
    private String prenom, adresse ;
    private Date dateInscri;
	private String role;
 
	
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", nom=" + nom + ", mdp=" + password + ", prenom=" + prenom
				+ ", adresse=" + adresse + ", dateInscri=" + dateInscri + ", role=" + role ;
	}


	public void setPassword(String encodedPassword) {
this.password=encodedPassword;		
	}


	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public Date getDateInscri() {
		return dateInscri;
	}


	public void setDateInscri(Date dateInscri) {
		this.dateInscri = dateInscri;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}



}
