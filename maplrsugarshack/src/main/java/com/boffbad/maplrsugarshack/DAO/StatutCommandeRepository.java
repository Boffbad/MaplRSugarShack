package com.boffbad.maplrsugarshack.DAO;

import org.springframework.data.repository.CrudRepository;

import com.boffbad.maplrsugarshack.model.StatutCommande;

public interface StatutCommandeRepository extends CrudRepository<StatutCommande, Integer>{

	StatutCommande findByNom(String nom);


}
