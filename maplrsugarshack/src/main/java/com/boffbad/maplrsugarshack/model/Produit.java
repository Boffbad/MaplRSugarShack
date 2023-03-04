package com.boffbad.maplrsugarshack.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity  
@Table
public class Produit {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String nom;
	
	@ManyToOne(cascade=CascadeType.ALL)  
	private TypeSirop typeSirop;
	
	@Column 
	private String description;
	
	@Column
	private String contenance;
	
	@Column
	private int prix;
	
	@Column
	private String imageUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContenance() {
		return contenance;
	}

	public void setContenance(String contenance) {
		this.contenance = contenance;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public TypeSirop getType() {
		return typeSirop;
	}

	public void setType(TypeSirop type) {
		this.typeSirop = type;
	}
	
}
