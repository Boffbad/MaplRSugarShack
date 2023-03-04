package com.boffbad.maplrsugarshack.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.boffbad.maplrsugarshack.model.Commande;
import com.boffbad.maplrsugarshack.model.LigneCommande;

public interface LigneCommandeRepository extends CrudRepository<LigneCommande, Integer> {

	List<LigneCommande> findAllByCommande(Commande commande);

}
