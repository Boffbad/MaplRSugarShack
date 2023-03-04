package com.boffbad.maplrsugarshack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class StatutCommande {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	
	@Column
	public String nom;
	
}
