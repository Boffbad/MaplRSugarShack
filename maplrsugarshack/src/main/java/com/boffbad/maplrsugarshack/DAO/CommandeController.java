package com.boffbad.maplrsugarshack.DAO;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boffbad.maplrsugarshack.model.Commande;
import com.boffbad.maplrsugarshack.model.StatutCommande;


@RestController
@CrossOrigin("*")
public class CommandeController {

	@Autowired
	CommandeRepository commandeRepository;
	@Autowired
	StatutCommandeRepository statutCommandeRepository;
	
	@GetMapping("/commandes")
	public List<Commande> getAllCommandes() {
		List<Commande> findAll = (List<Commande>) commandeRepository.findAll();
		Collections.sort(findAll, new java.util.Comparator<Commande>() {

			@Override
			public int compare(Commande c1, Commande c2) {
				
				return c1.getId() - c2.getId();
			}
			
		});
		return findAll;
		
	}

	@PutMapping("/commande/valider/{id}")
	public void validerCommande(@PathVariable("id") int id, @RequestBody Commande commande){
		Commande cmde = commandeRepository.findById(id).get();
		
		if(cmde != null) {
			StatutCommande statutCommande = statutCommandeRepository.findByNom("Valide");
			cmde.setStatutCommande(statutCommande);
			commandeRepository.save(cmde);
		}
	}
	
}
