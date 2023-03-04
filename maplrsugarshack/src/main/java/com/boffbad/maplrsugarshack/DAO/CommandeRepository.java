package com.boffbad.maplrsugarshack.DAO;

import org.springframework.data.repository.CrudRepository;

import com.boffbad.maplrsugarshack.model.Commande;
import com.boffbad.maplrsugarshack.model.StatutCommande;

public interface CommandeRepository extends CrudRepository<Commande, Integer>{

	Commande findByStatutCommande(StatutCommande statutCommande);

}
